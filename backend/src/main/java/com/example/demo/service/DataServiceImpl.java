package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DataServiceImpl {
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



    public JSONObject getModelPerformance(JSONArray datasetList,String kind,Boolean mode) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            Map<String,Map<String ,String>> map = new HashMap<>();

            List<Paper> papers = paperMapper.selectByExample(new PaperExample());
            Map<String,String> paperParams = new HashMap<>();
            for (Paper paper : papers){
                float performance = paper.getPaperScore();
                if (!mode){
                    ModelExample modelExample = new ModelExample();
                    ModelExample.Criteria criteria = modelExample.createCriteria();
                    criteria.andPaperIdEqualTo(paper.getPaperId());
                    List<Model> models = modelMapper.selectByExample(modelExample);
                    Float max = -99999f;
                    for(Model model : models){
                        if(model.getModelRemark() > max)
                            max = model.getModelRemark();
                    }
                    performance = max;
                }
                String paperName = paper.getPaperModel();

                paperParams.put(paperName,paper.getPaperDescription());

                Dataset dataset = datasetMapper.selectByPrimaryKey(paper.getDatasetId());
                String datasetName = dataset.getDatasetName();
                Task task = taskMapper.selectByPrimaryKey(dataset.getTaskId());
                if (task.getTaskClass().equals(kind)) {
                    if (!map.containsKey(paperName)) {
                        Map<String, String> map1 = new HashMap<>();

                        map.put(paperName, map1);
                    }
                    map.get(paperName).put(datasetName, String.valueOf(performance));
                }
            }

            for (String pn : map.keySet()){

                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("modelName",pn);
                jsonObject1.put("params",paperParams.get(pn));
                float average = 0f;
                int cnt = 0;
                for (String datasetName:map.get(pn).keySet()){
                    String perf = map.get(pn).get(datasetName);

                    jsonObject1.put(datasetName,perf);
                    if (!"".equals(perf)) {
                        average += Float.parseFloat(perf);
                        cnt++;
                    }
                }
                float T = average/cnt;
                BigDecimal b = new BigDecimal(T);
                T = b.setScale(2, RoundingMode.HALF_UP).floatValue();
                jsonObject1.put("average",T);
                if(jsonObject1.size()==9)
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


    public JSONObject getSubmitPerformance(JSONArray datasetList, String kind, Boolean mode) {
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            Map<String,Map<String ,String>> map = new HashMap<>();
            Map<String,String> submissionParams = new HashMap<>();

            List<Submission> submissions = submissionMapper.selectByExample(new SubmissionExample());
            for (Submission submission: submissions){

                float performance = submission.getSubmissionScore();

                if (!mode){
                    SubmitExample submitExample = new SubmitExample();
                    SubmitExample.Criteria criteria = submitExample.createCriteria();
                    criteria.andSubmissionIdEqualTo(submission.getSubmissionId());
                    List<Submit> submits = submitMapper.selectByExample(submitExample);
                    Float max = -99999f;
                    for(Submit submit : submits){
                        if(submit.getSubmitRemark() > max)
                            max = submit.getSubmitRemark();
                    }
                    performance = max;
                }

                String submissionName = submission.getSubmissionName();
                submissionParams.put(submissionName,submission.getSubmissionParams());

                Dataset dataset = datasetMapper.selectByPrimaryKey(submission.getDatasetId());
                String datasetName = dataset.getDatasetName();
                Task task = taskMapper.selectByPrimaryKey(dataset.getTaskId());
                if (task.getTaskClass().equals(kind)) {

                    if (!map.containsKey(submissionName)) {
                        Map<String, String> map1 = new HashMap<>();
                        map.put(submissionName, map1);
                    }
                    map.get(submissionName).put(datasetName, String.valueOf(performance));
                }
            }


            for (String sn : map.keySet()){



                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("modelName",sn);
                jsonObject1.put("params",submissionParams.get(sn));
                float average = 0f;
                int cnt = 0;

                for (String datasetName:map.get(sn).keySet()){

                    String perf = map.get(sn).get(datasetName);
                    jsonObject1.put(datasetName,perf);
                    if (!"".equals(perf)) {
                        average += Float.parseFloat(perf);
                        cnt++;
                    }
                }
                float T = average/cnt;
                BigDecimal b = new BigDecimal(T);
                T = b.setScale(2, RoundingMode.HALF_UP).floatValue();
                jsonObject1.put("average",T);
                if(jsonObject1.size()==9)
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

    public JSONObject getModelByToken(String token) {
        JSONObject jsonObject = new JSONObject();

        try {
            String email = "";
            if (TokenUtil.verify(token))
                email = TokenUtil.getEmail(token);
            User user = userMapper.selectByPrimaryKey(email);
            PaperExample paperExample = new PaperExample();
            PaperExample.Criteria criteria = paperExample.createCriteria();
            if (!"admin".equals(user.getUsername()))
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
            if (!"admin".equals(user.getUsername()))
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
            jsonObject.put("totalEntries",models.size()+submits.size());
            jsonObject.put("submissionList",submissionArray);
            jsonObject.put("code","200");
            return jsonObject;

        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


    public JSONObject deleteModelByID(Integer id, String submitType) {
        JSONObject jsonObject = new JSONObject();

        try {
            if ("Paper".equals(submitType)){
                Model model = modelMapper.selectByPrimaryKey(id);

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
    public JSONObject deleteModelsByIdList(JSONArray ids,JSONArray submitTypes){
        JSONObject jsonObject = new JSONObject();
        try {
            for (int i = 0;i<ids.size();i++){
                Integer id = Integer.parseInt(ids.get(i).toString());
                String submitType = submitTypes.get(i).toString();
                deleteModelByID(id,submitType);
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
