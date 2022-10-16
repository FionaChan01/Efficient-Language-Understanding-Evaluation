package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.*;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.DataService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DataServiceImpl implements DataService {
    @Autowired
    PaperMapper paperMapper;

    @Autowired
    SubmissionMapper submissionMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SubmitMapper submitMapper;

    @Autowired
    DatasetMapper datasetMapper;

    @Autowired
    TaskMapper taskMapper;

    @Override
    public JSONObject getPaperByDataset(Integer datasetId) {
        JSONObject jsonObject = new JSONObject();


        try {
            PaperExample paperExample = new PaperExample();
            PaperExample.Criteria criteria = paperExample.createCriteria();
            criteria.andDatasetIdEqualTo(datasetId);
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(paperMapper.selectByExample(paperExample));
            jsonObject.put("paperlist",jsonArray);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject getSubmissionByDataset(Integer datasetId) {
        JSONObject jsonObject = new JSONObject();


        try {
            SubmissionExample submissionExample = new SubmissionExample();
            SubmissionExample.Criteria criteria = submissionExample.createCriteria();
            criteria.andDatasetIdEqualTo(datasetId);
            JSONArray jsonArray = new JSONArray();
            List<Submission> list = submissionMapper.selectByExample(submissionExample);
            jsonArray.addAll(list);
            jsonObject.put("submissionlist",jsonArray);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject getModelByPaper(Integer paperId) {

        JSONObject jsonObject = new JSONObject();


        try {
           ModelExample modelExample = new ModelExample();
            ModelExample.Criteria criteria = modelExample.createCriteria();
            criteria.andPaperIdEqualTo(paperId);
            JSONArray jsonArray = new JSONArray();
            jsonArray.addAll(modelMapper.selectByExample(modelExample));
            jsonObject.put("modellist",jsonArray);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject getModelByPaperList(JSONArray paperList) {
        JSONObject jsonObject = new JSONObject();

        JSONArray jsonArray1 = new JSONArray();
        try {
            for (Object o : paperList){
                JSONArray jsonArray = new JSONArray();
                Integer paperId = Integer.parseInt(o.toString());
                ModelExample modelExample = new ModelExample();
                ModelExample.Criteria criteria = modelExample.createCriteria();
                criteria.andPaperIdEqualTo(paperId);
                jsonArray.addAll(modelMapper.selectByExample(modelExample));
                jsonArray1.add(jsonArray);
            }
            jsonObject.put("modellist",jsonArray1);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


    @Override
    public JSONObject getSubmitBySubmissionList(JSONArray submissionList) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();

        try {
            for (Object o : submissionList){
                JSONArray jsonArray = new JSONArray();
                Integer submitId = Integer.parseInt(o.toString());
                SubmitExample submitExample = new SubmitExample();
                SubmitExample.Criteria criteria = submitExample.createCriteria();
                criteria.andSubmissionIdEqualTo(submitId);
                jsonArray.addAll(submitMapper.selectByExample(submitExample));
                jsonArray1.add(jsonArray);
            }
            jsonObject.put("submitlist",jsonArray1);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


    @Override
    public JSONObject getModelPerformance(JSONArray datasetList,String kind) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            Map<ModelHelp,Map<String ,String>> map = new HashMap<>();
            ModelExample modelExample = new ModelExample();
            List<Model> models = modelMapper.selectByExample(modelExample);
            for (Model model : models){
                int flops = model.getModelFlops();
                int params = model.getModelParams();
                float performance = model.getModelRemark();

                Integer paperId = model.getPaperId();
                Paper paper = paperMapper.selectByPrimaryKey(paperId);
                String modelName = paper.getPaperModel();
                Dataset dataset = datasetMapper.selectByPrimaryKey(paper.getDatasetId());
                String datasetName = dataset.getDatasetName();
                Task task = taskMapper.selectByPrimaryKey(dataset.getTaskId());
                if (task.getTaskClass().equals(kind)) {
                    ModelHelp modelHelp = new ModelHelp(modelName, params, flops);
                    if (!map.containsKey(modelHelp)) {
                        Map<String, String> map1 = new HashMap<>();
                        for (Object o1 : datasetList) {
                            map1.put(o1.toString(), "");
                        }
                        map.put(modelHelp, map1);
                    }
                    map.get(modelHelp).put(datasetName, String.valueOf(performance));
                }
            }

            for (ModelHelp modelHelp : map.keySet()){
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("modelName",modelHelp.getModelName());
                jsonObject1.put("flops",modelHelp.getFlops());
                jsonObject1.put("params",modelHelp.getParams());
                float average = 0f;
                int cnt = 0;
                for (String datasetName:map.get(modelHelp).keySet()){
                    String perf = map.get(modelHelp).get(datasetName);
                    jsonObject1.put(datasetName,perf);
                    if (!"".equals(perf)) {
                        average += Float.parseFloat(perf);
                        cnt++;
                    }
                }
                jsonObject1.put("average",average/cnt);
                jsonArray.add(jsonObject1);
            }
            jsonObject.put("performanceList",jsonArray);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject getSubmitPerformance(JSONArray datasetList, String kind) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            Map<ModelHelp,Map<String ,String>> map = new HashMap<>();
            SubmitExample submitExample = new SubmitExample();
            List<Submit> submits = submitMapper.selectByExample(submitExample);
            for (Submit submit: submits){
                int flops = submit.getSubmitFlops();
                int params = submit.getSubmitParams();
                float performance = submit.getSubmitRemark();

                Integer submissionId = submit.getSubmissionId();
                Submission submission = submissionMapper.selectByPrimaryKey(submissionId);
                String modelName = submission.getSubmissionName();
                Dataset dataset = datasetMapper.selectByPrimaryKey(submission.getDatasetId());
                String datasetName = dataset.getDatasetName();
                Task task = taskMapper.selectByPrimaryKey(dataset.getTaskId());
                if (task.getTaskClass().equals(kind)) {
                    ModelHelp modelHelp = new ModelHelp(modelName, params, flops);
                    if (!map.containsKey(modelHelp)) {
                        Map<String, String> map1 = new HashMap<>();
                        for (Object o1 : datasetList) {
                            map1.put(o1.toString(), "");
                        }
                        map.put(modelHelp, map1);
                    }
                    map.get(modelHelp).put(datasetName, String.valueOf(performance));
                }
            }

            for (ModelHelp modelHelp : map.keySet()){
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("modelName",modelHelp.getModelName());
                jsonObject1.put("flops",modelHelp.getFlops());
                jsonObject1.put("params",modelHelp.getParams());
                float average = 0f;
                int cnt = 0;
                for (String datasetName:map.get(modelHelp).keySet()){
                    String perf = map.get(modelHelp).get(datasetName);
                    jsonObject1.put(datasetName,perf);
                    if (!"".equals(perf)) {
                        average += Float.parseFloat(perf);
                        cnt++;
                    }
                }
                jsonObject1.put("average",average/cnt);
                jsonArray.add(jsonObject1);
            }
            jsonObject.put("performanceList",jsonArray);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject getModelByToken(String token) {
        JSONObject jsonObject = new JSONObject();

        try {
            String email = "";
            if (TokenUtil.verify(token))
                email = TokenUtil.getEmail(token);
            PaperExample paperExample = new PaperExample();
            PaperExample.Criteria criteria = paperExample.createCriteria();
            criteria.andEmailEqualTo(email);
            List<Paper> papers = paperMapper.selectByExample(paperExample);
            JSONArray models = new JSONArray();
            JSONArray paperArray = new JSONArray();
            paperArray.addAll(papers);
            JSONArray datasets = new JSONArray();
            for (Paper paper : papers)
                datasets.add(datasetMapper.selectByPrimaryKey(paper.getDatasetId()).getDatasetName());
            for (Paper paper:papers){
                JSONArray jsonArray = new JSONArray();
                ModelExample modelExample = new ModelExample();
                ModelExample.Criteria criteria1 = modelExample.createCriteria();
                criteria1.andPaperIdEqualTo(paper.getPaperId());
                jsonArray.addAll(modelMapper.selectByExample(modelExample));
                models.add(jsonArray);
            }

            SubmissionExample submissionExample = new SubmissionExample();
            SubmissionExample.Criteria criteria1 = submissionExample.createCriteria();
            criteria1.andEmailEqualTo(email);
            List<Submission> submissionList = submissionMapper.selectByExample(submissionExample);
            JSONArray submits = new JSONArray();
            JSONArray submissionArray = new JSONArray();
            submissionArray.addAll(submissionList);

            JSONArray datasetList = new JSONArray();
            for (Submission submission : submissionList){
                datasetList.add(datasetMapper.selectByPrimaryKey(submission.getDatasetId()).getDatasetName());
            }

            for (Submission submission : submissionList){
                JSONArray jsonArray = new JSONArray();
                SubmitExample submitExample = new SubmitExample();
                SubmitExample.Criteria criteria2 = submitExample.createCriteria();
                criteria2.andSubmissionIdEqualTo(submission.getSubmissionId());
                jsonArray.addAll(submitMapper.selectByExample(submitExample));
                submits.add(jsonArray);
            }
            jsonObject.put("paperDatasetList",datasets);
            jsonObject.put("submissionDatasetList",datasetList);
            jsonObject.put("modelList",models);
            jsonObject.put("paperList",paperArray);
            jsonObject.put("submitList",submits);
            jsonObject.put("submissionList",submissionArray);
            jsonObject.put("code","200");
            return jsonObject;

        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    @Override
    public JSONObject deleteModelByID(Integer id, String submitType) {
        JSONObject jsonObject = new JSONObject();

        try {
            if ("Paper".equals(submitType)){
                Model model = modelMapper.selectByPrimaryKey(id);
                System.out.println(id);
                Integer paperId = model.getPaperId();

                modelMapper.deleteByPrimaryKey(id);
                ModelExample modelExample = new ModelExample();
                ModelExample.Criteria criteria = modelExample.createCriteria();
                criteria.andPaperIdEqualTo(paperId);
                if (modelMapper.selectByExample(modelExample).size() == 0)
                    paperMapper.deleteByPrimaryKey(paperId);

            }
            if ("Test File".equals(submitType)){
                Submit submit = submitMapper.selectByPrimaryKey(id);
                Integer submissionId = submit.getSubmissionId();
                submitMapper.deleteByPrimaryKey(id);
                SubmitExample submitExample = new SubmitExample();
                SubmitExample.Criteria criteria = submitExample.createCriteria();
                criteria.andSubmissionIdEqualTo(submissionId);
                if (submitMapper.selectByExample(submitExample).size()==0)
                    submissionMapper.deleteByPrimaryKey(submissionId);
            }
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


}
