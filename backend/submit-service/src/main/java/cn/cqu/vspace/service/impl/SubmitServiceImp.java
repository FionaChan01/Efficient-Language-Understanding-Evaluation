package cn.cqu.vspace.service.impl;


import cn.cqu.vspace.mapper.*;
import cn.cqu.vspace.pojo.*;
import cn.cqu.vspace.service.SubmitService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SubmitServiceImp implements SubmitService {

    @Autowired
    PaperMapper paperMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DatasetMapper datasetMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SubmissionMapper submissionMapper;

    @Autowired
    SubmitMapper submitMapper;

    @Override
    @Transactional
    public JSONObject submitPaper(String codeUrl, String modelName, String paperTitle, String paperUrl, String token,
                                  Integer datasetId,JSONArray flops,JSONArray params,JSONArray remark) {
        JSONObject jsonObject = new JSONObject();
        try {
            String email = "";

            if (!"".equals(token) && TokenUtil.verify(token)){

                email = TokenUtil.getEmail(token);

            }
            Dataset dataset = datasetMapper.selectByPrimaryKey(datasetId);
            Paper paper = new Paper();
            paper.setDatasetId(datasetId);
            paper.setEmail(email);
            paper.setPaperName(paperTitle);
            paper.setPaperWebsite(paperUrl);
            paper.setPaperCode(codeUrl);
            paper.setPaperModel(modelName);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
            TimeZone.setDefault(timeZone);
            paper.setPaperTime(new Date());
            paperMapper.insert(paper);
            for (int i=0;i<remark.size();i++){
                Model model = new Model();
                model.setPaperId(paper.getPaperId());
                model.setModelRemark(Float.parseFloat(remark.get(i).toString()));
                model.setModelParams(Integer.parseInt(params.get(i).toString()));
                model.setModelFlops(Integer.parseInt(flops.get(i).toString()));
                modelMapper.insert(model);
            }
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }


    }

    @Override
    @Transactional
    public JSONObject submitSubmission(Integer datasetId, MultipartFile[] files, JSONArray flops, JSONArray params,
                                       String description,String affiliation,String token, String submissionName) {
        JSONObject jsonObject = new JSONObject();
        Submission submission = new Submission();
        try {

            String email = "";


            if (!"".equals(token) && TokenUtil.verify(token)){
                email = TokenUtil.getEmail(token);

            }

            // 查出测试集

            Dataset dataset = datasetMapper.selectByPrimaryKey(datasetId);

            submission.setDatasetId(datasetId);
            submission.setEmail(email);
            submission.setSubmissionDescription(description);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
            TimeZone.setDefault(timeZone);
            submission.setSubmissionTime(new Date());
            submission.setSubmissionName(submissionName);
            submission.setSubmissionAffiliation(affiliation);
            submissionMapper.insert(submission);
            // 获取测试集名字
            String datasetName = dataset.getDatasetName();
            String taskName = "";
            if ("SST-2".equals(datasetName)){
                taskName = "sst";
            }else if ("IMDb".equals(datasetName)){
                taskName = "imdb";
            }else if ("SNLI".equals(datasetName)){
                taskName = "snli";
            }else if ("MRPC".equals(datasetName)){
                taskName = "mrpc";
            }else if ("STS-B".equals(datasetName)){
                taskName = "sts";
            }else if ("CoNLL2003(pos)".equals(datasetName)){
                taskName = "pos";
            }
            else if ("CoNLL2003(corrected error)".equals(datasetName)){
                taskName = "ner";
            }else if ("CoNLL2003(chunk)".equals(datasetName)){
                taskName = "chunk";
            }else if("SciTail".equals(datasetName)){
                taskName = "scitail";
            }
            for (int i = 0;i<files.length;i++){
                File file = FileUtil.multipartFileToFile(files[i]);
                String[] arg = new String[]{"python", "C:\\Users\\Lenovo\\Desktop\\eval_elue.py", "--task_name", taskName, "--test_file",file.getAbsolutePath()};
                Process pr = Runtime.getRuntime().exec(arg);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line;
                line = bufferedReader.readLine();
                Submit submit = new Submit();
                submit.setSubmitFlops(Integer.parseInt(flops.get(i).toString()));
                submit.setSubmitParams(Integer.parseInt(params.get(i).toString()));
                submit.setSubmitRemark(Float.parseFloat(line) * 100);
                submit.setSubmissionId(submission.getSubmissionId());
                submitMapper.insert(submit);
                bufferedReader.close();
                pr.waitFor();
                FileUtil.delteTempFile(file);
            }


            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            submissionMapper.deleteByPrimaryKey(submission.getSubmissionId());
            return jsonObject;
        }
    }

    @Override
    @Transactional
    public JSONObject submitType2(Integer datasetId, MultipartFile[] tsvfile, MultipartFile pyfile, String description, String affiliation, String token, String submissionName) {
        JSONObject jsonObject = new JSONObject();
        Submission submission = new Submission();
        try {

            String email = "";


            if (!"".equals(token) && TokenUtil.verify(token)){
                email = TokenUtil.getEmail(token);

            }

            // 查出测试集

            Dataset dataset = datasetMapper.selectByPrimaryKey(datasetId);

            submission.setDatasetId(datasetId);
            submission.setEmail(email);
            submission.setSubmissionDescription(description);
            TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
            TimeZone.setDefault(timeZone);
            submission.setSubmissionTime(new Date());
            submission.setSubmissionName(submissionName);
            submission.setSubmissionAffiliation(affiliation);
            submissionMapper.insert(submission);
            // 获取测试集名字
            String datasetName = dataset.getDatasetName();
            String taskName = "";
            if ("SST-2".equals(datasetName)){
                taskName = "sst";
            }else if ("IMDb".equals(datasetName)){
                taskName = "imdb";
            }else if ("SNLI".equals(datasetName)){
                taskName = "snli";
            }else if ("MRPC".equals(datasetName)){
                taskName = "mrpc";
            }else if ("STS-B".equals(datasetName)){
                taskName = "sts";
            }else if ("CoNLL2003(pos)".equals(datasetName)){
                taskName = "pos";
            }
            else if ("CoNLL2003(corrected error)".equals(datasetName)){
                taskName = "ner";
            }else if ("CoNLL2003(chunk)".equals(datasetName)){
                taskName = "chunk";
            }else if("SciTail".equals(datasetName)){
                taskName = "scitail";
            }
            int flops = 0;
            int params = 0;
            for (int i = 0;i<tsvfile.length;i++){
                if (i==0) {
                    File pyFile = FileUtil.multipartFileToFile(pyfile);
                    File tmpFile = new File("C:\\Users\\Lenovo\\Desktop\\pythonProject1\\model_to_eval.py");
                    if (tmpFile.exists())
                        tmpFile.delete();
                    FileUtil.copyFile(pyFile.getAbsolutePath(), tmpFile.getAbsolutePath());
                    File file = FileUtil.multipartFileToFile(tsvfile[i]);
                    String[] arg = new String[]{"python", "C:\\Users\\Lenovo\\Desktop\\pythonProject1\\eval_elue.py", "--task_name", taskName, "--test_file", file.getAbsolutePath()};
                    Process pr = Runtime.getRuntime().exec(arg);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String line;
                    line = bufferedReader.readLine();
                    JSONObject jsonObject1 = JSONObject.parseObject(line);
                    Submit submit = new Submit();
                    flops = (int) (Float.parseFloat(jsonObject1.get("MFLOPs").toString()) + 0.5);
                    params = (int) (Float.parseFloat(jsonObject1.get("Mparams").toString()) + 0.5);
                    submit.setSubmitRemark(Float.parseFloat(jsonObject1.get("Performance").toString()) * 100);
                    submit.setSubmitFlops(flops);
                    submit.setSubmitParams(params);
                    submit.setSubmissionId(submission.getSubmissionId());
                    submitMapper.insert(submit);
                    bufferedReader.close();
                    pr.waitFor();
                    FileUtil.delteTempFile(file);
                    FileUtil.delteTempFile(pyFile);
                }
                else {
                    File file = FileUtil.multipartFileToFile(tsvfile[i]);
                    String[] arg = new String[]{"python", "C:\\Users\\Lenovo\\Desktop\\eval_elue.py", "--task_name", taskName, "--test_file",file.getAbsolutePath()};
                    Process pr = Runtime.getRuntime().exec(arg);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                    String line;
                    line = bufferedReader.readLine();
                    Submit submit = new Submit();
                    submit.setSubmitFlops(flops);
                    submit.setSubmitParams(params);
                    submit.setSubmitRemark(Float.parseFloat(line) * 100);
                    submit.setSubmissionId(submission.getSubmissionId());
                    submitMapper.insert(submit);
                    bufferedReader.close();
                    pr.waitFor();
                    FileUtil.delteTempFile(file);
                }
            }


            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            submissionMapper.deleteByPrimaryKey(submission.getSubmissionId());
            return jsonObject;
        }
    }


}
