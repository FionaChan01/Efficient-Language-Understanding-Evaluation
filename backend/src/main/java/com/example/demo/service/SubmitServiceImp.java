package com.example.demo.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

import static java.lang.Thread.sleep;

@Service
public class SubmitServiceImp {

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

    static Queue<Info> infoQueue = new LinkedList<>();

    static Boolean isBusy = false;

    @Transactional
    public JSONObject submitPaper(String codeUrl, String modelName, String paperTitle, String paperUrl, String token,
                                  Integer datasetId, JSONArray flops, JSONArray params, JSONArray remark) {


        JSONObject jsonObject = new JSONObject();
        try {
            String email = "";

            if (!"".equals(token) && TokenUtil.verify(token)) {

                email = TokenUtil.getEmail(token);

            }
            Dataset dataset = datasetMapper.selectByPrimaryKey(datasetId);
            String datasetName = dataset.getDatasetName();
            String taskName = "";
            if ("SST-2".equals(datasetName)) {
                taskName = "sst";
            } else if ("IMDb".equals(datasetName)) {
                taskName = "imdb";
            } else if ("SNLI".equals(datasetName)) {
                taskName = "snli";
            } else if ("MRPC".equals(datasetName)) {
                taskName = "mrpc";
            } else if ("STS-B".equals(datasetName)) {
                taskName = "sts";
            } else if ("CoNLL2003(pos)".equals(datasetName)) {
                taskName = "pos";
            } else if ("CoNLL2003(corrected error)".equals(datasetName)) {
                taskName = "ner";
            } else if ("CoNLL2003(chunk)".equals(datasetName)) {
                taskName = "chunk";
            } else if ("SciTail".equals(datasetName)) {
                taskName = "scitail";
            }
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

            List<String> f = new ArrayList<>();
            List<String> p = new ArrayList<>();

            Float maxParams = 0f;
            for (int i = 0; i < remark.size(); i++) {
                Model model = new Model();
                model.setPaperId(paper.getPaperId());
                model.setModelRemark(Float.parseFloat(remark.get(i).toString()));
                model.setModelParams(Float.parseFloat(params.get(i).toString()));
                model.setModelFlops(Float.parseFloat(flops.get(i).toString()));
                modelMapper.insert(model);
                f.add(String.valueOf(model.getModelFlops()));
                p.add(String.valueOf(model.getModelRemark()));
                if (model.getModelParams() > maxParams)
                    maxParams = model.getModelParams();
            }
            paper.setPaperDescription(String.valueOf(maxParams));
            String[] arg = new String[8 + f.size() + p.size()];
            arg[0] = "python";
            arg[1] = "-W";
            arg[2] = "ignore";
            arg[3] = "/elue_score.py";
            arg[4] = "--task_name";
            arg[5] = taskName;
            arg[6] = "--flops_submitted_by_user";
            for (int i = 7; i < 7 + f.size(); i++) {
                arg[i] = f.get(i - 7);
            }
            arg[7 + f.size()] = "--perfs_submitted_by_user";
            for (int i = 8 + f.size(); i < 8 + f.size() + p.size(); i++) {
                arg[i] = p.get(i - 8 - f.size());
            }
            System.out.println(Arrays.toString(arg));
            Process pr = Runtime.getRuntime().exec(arg);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            line = bufferedReader.readLine();
            float T = Float.parseFloat(line);
            BigDecimal b = new BigDecimal(T);
            T = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            paper.setPaperScore(T);

            paperMapper.updateByPrimaryKey(paper);


            jsonObject.put("code", "200");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", "500");
            jsonObject.put("info", e.getMessage());
            return jsonObject;
        }


    }


    @Transactional
    public JSONObject submitSubmission(Integer datasetId, MultipartFile[] files, JSONArray flops, JSONArray params,
                                       String description, String affiliation, String token, String submissionName,
                                       String mode) {


        JSONObject jsonObject = new JSONObject();

        Submission submission = new Submission();
        try {

            String email = "";


            if (!"".equals(token) && TokenUtil.verify(token)) {
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
            if ("leaderboard".equals(mode))
                submissionMapper.insert(submission);
            // 获取测试集名字
            String datasetName = dataset.getDatasetName();
            String taskName = "";
            if ("SST-2".equals(datasetName)) {
                taskName = "sst";
            } else if ("IMDb".equals(datasetName)) {
                taskName = "imdb";
            } else if ("SNLI".equals(datasetName)) {
                taskName = "snli";
            } else if ("MRPC".equals(datasetName)) {
                taskName = "mrpc";
            } else if ("STS-B".equals(datasetName)) {
                taskName = "sts";
            } else if ("CoNLL2003(pos)".equals(datasetName)) {
                taskName = "pos";
            } else if ("CoNLL2003(corrected error)".equals(datasetName)) {
                taskName = "ner";
            } else if ("CoNLL2003(chunk)".equals(datasetName)) {
                taskName = "chunk";
            } else if ("SciTail".equals(datasetName)) {
                taskName = "scitail";
            }
            Float maxParams = 0f;
            List<String> f = new ArrayList<>();
            List<String> p = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                File file = FileUtil.multipartFileToFile(files[i]);
                String[] arg = new String[]{"python", "-W", "ignore", "/eval_elue.py", "--task_name", taskName, "--test_file", file.getAbsolutePath()};
                Process pr = Runtime.getRuntime().exec(arg);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                String line;
                line = bufferedReader.readLine();
                Submit submit = new Submit();
                submit.setSubmitFlops(Float.parseFloat(flops.get(i).toString()));
                submit.setSubmitParams(Float.parseFloat(params.get(i).toString()));
                submit.setSubmitRemark(Float.parseFloat(line) * 100);
                submit.setSubmissionId(submission.getSubmissionId());
                if ("leaderboard".equals(mode))
                    submitMapper.insert(submit);
                bufferedReader.close();
                pr.waitFor();
                FileUtil.delteTempFile(file);
                f.add(String.valueOf(submit.getSubmitFlops()));
                p.add(String.valueOf(submit.getSubmitRemark()));
                if (submit.getSubmitParams() > maxParams)
                    maxParams = submit.getSubmitParams();
            }
            submission.setSubmissionParams(String.valueOf(maxParams));
            String[] arg = new String[8 + f.size() + p.size()];
            arg[0] = "python";
            arg[1] = "-W";
            arg[2] = "ignore";
            arg[3] = "/elue_score.py";
            arg[4] = "--task_name";
            arg[5] = taskName;
            arg[6] = "--flops_submitted_by_user";
            for (int i = 7; i < 7 + f.size(); i++) {
                arg[i] = f.get(i - 7);
            }
            arg[7 + f.size()] = "--perfs_submitted_by_user";
            for (int i = 8 + f.size(); i < 8 + f.size() + p.size(); i++) {
                arg[i] = p.get(i - 8 - f.size());
            }
            Process pr = Runtime.getRuntime().exec(arg);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            line = bufferedReader.readLine();
            System.out.println(Arrays.toString(arg));
            float T = Float.parseFloat(line);
            BigDecimal b = new BigDecimal(T);
            T = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            submission.setSubmissionScore(T);
            if ("leaderboard".equals(mode))
                submissionMapper.updateByPrimaryKey(submission);
            jsonObject.put("score",T);
            jsonObject.put("code", "200");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", "500");
            if ("leaderboard".equals(mode))
                submissionMapper.deleteByPrimaryKey(submission.getSubmissionId());
            return jsonObject;
        }
    }


    @Transactional
    public JSONObject submitType2(Integer datasetId, MultipartFile[] tsvfile, MultipartFile pyfile, String description, String affiliation, String token, String submissionName) {

        JSONObject jsonObject = new JSONObject();
        try {
            String email = "";
            if (!"".equals(token) && TokenUtil.verify(token)) {
                email = TokenUtil.getEmail(token);
            }
            System.out.println(pyfile.getName());
            System.out.println(pyfile.getSize());
            while (true) {
                synchronized (this) {
                    if (!isBusy)
                        break;
                    wait(10000);
                }
            }
            File pyFile = FileUtil.multipartFileToFile(pyfile);
            File [] files = new File[tsvfile.length];
            for (int i =0;i<tsvfile.length;i++)
                files[i] = FileUtil.multipartFileToFile(tsvfile[i]);
            infoQueue.offer(new Info(datasetId,email,description,submissionName,affiliation,files,pyFile));
            jsonObject.put("code", "200");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", "500");
            return jsonObject;
        }
    }

    @Component
    static class ApplicationRunnerImpl implements ApplicationRunner {
        @Autowired
        DatasetMapper datasetMapper;
        @Autowired
        SubmissionMapper submissionMapper;
        @Autowired
        SubmitMapper submitMapper;
        @Override
        public void run(ApplicationArguments args) throws Exception {
            while (true){
                synchronized (this) {
                    wait(3000);
                    if (!infoQueue.isEmpty()){
                        isBusy = true;
                        Submission submission = new Submission();
                        try {

                            Info info = infoQueue.poll();
                            Integer datasetId = info.datasetId;
                            String email = info.email;
                            String description = info.description;
                            String submissionName = info.submissionName;
                            String affiliation = info.affiliation;
                            File[] tsvfile = info.tsvfile;
                            File pyFile = info.pyfile;
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
                            if ("SST-2".equals(datasetName)) {
                                taskName = "sst";
                            } else if ("IMDb".equals(datasetName)) {
                                taskName = "imdb";
                            } else if ("SNLI".equals(datasetName)) {
                                taskName = "snli";
                            } else if ("MRPC".equals(datasetName)) {
                                taskName = "mrpc";
                            } else if ("STS-B".equals(datasetName)) {
                                taskName = "sts";
                            } else if ("CoNLL2003(pos)".equals(datasetName)) {
                                taskName = "pos";
                            } else if ("CoNLL2003(corrected error)".equals(datasetName)) {
                                taskName = "ner";
                            } else if ("CoNLL2003(chunk)".equals(datasetName)) {
                                taskName = "chunk";
                            } else if ("SciTail".equals(datasetName)) {
                                taskName = "scitail";
                            }
                            float flops;
                            float params;
                            Float maxParams = 0f;
                            List<String> f = new ArrayList<>();
                            List<String> p = new ArrayList<>();
                            for (File file : tsvfile) {
                                File tmpFile = new File("/pythonProject1/model_to_eval.py");
                                if (tmpFile.exists())
                                    tmpFile.delete();
                                System.out.println(1);

                                System.out.println(pyFile);

                                FileUtil.copyFile(pyFile.getAbsolutePath(), tmpFile.getAbsolutePath());

                                System.out.println(1);
                                System.out.println(1);
                                String[] arg = new String[]{"python", "-W", "ignore", "/pythonProject1/eval_elue.py", "--task_name", taskName, "--test_file", file.getAbsolutePath()};
                                Process pr = Runtime.getRuntime().exec(arg);
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                                String line;
                                line = bufferedReader.readLine();
                                JSONObject jsonObject1 = JSONObject.parseObject(line);
                                System.out.println(line);
                                Submit submit = new Submit();
                                flops = (Float.parseFloat(jsonObject1.get("MFLOPs").toString()));
                                params = (Float.parseFloat(jsonObject1.get("Mparams").toString()));
                                submit.setSubmitRemark(Float.parseFloat(jsonObject1.get("Performance").toString()) * 100);

                                BigDecimal b = new BigDecimal(flops);
                                flops = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

                                BigDecimal a = new BigDecimal(params);
                                params = a.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                                submit.setSubmitFlops(flops);
                                submit.setSubmitParams(params);
                                submit.setSubmissionId(submission.getSubmissionId());
                                submitMapper.insert(submit);
                                bufferedReader.close();
                                pr.waitFor();
                                FileUtil.delteTempFile(file);
                                FileUtil.delteTempFile(pyFile);
                                f.add(String.valueOf(submit.getSubmitFlops()));
                                p.add(String.valueOf(submit.getSubmitRemark()));
                                if (submit.getSubmitParams() > maxParams)
                                    maxParams = submit.getSubmitParams();
                            }
                            submission.setSubmissionParams(String.valueOf(maxParams));
                            String[] arg = new String[8 + f.size() + p.size()];
                            arg[0] = "python";
                            arg[1] = "-W";
                            arg[2] = "ignore";
                            arg[3] = "/elue_score.py";
                            arg[4] = "--task_name";
                            arg[5] = taskName;
                            arg[6] = "--flops_submitted_by_user";
                            for (int i = 7; i < 7 + f.size(); i++) {
                                arg[i] = f.get(i - 7);
                            }
                            arg[7 + f.size()] = "--perfs_submitted_by_user";
                            for (int i = 8 + f.size(); i < 8 + f.size() + p.size(); i++) {
                                arg[i] = p.get(i - 8 - f.size());
                            }
                            Process pr = Runtime.getRuntime().exec(arg);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                            String line;
                            line = bufferedReader.readLine();
                            System.out.println(Arrays.toString(arg));
                            float T = Float.parseFloat(line);
                            BigDecimal b = new BigDecimal(T);
                            T = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                            submission.setSubmissionScore(T);
                            submissionMapper.updateByPrimaryKey(submission);
                            isBusy = false;
                        }catch (Exception e){
                            e.printStackTrace();
                            submissionMapper.deleteByPrimaryKey(submission.getSubmissionId());
                            isBusy = false;
                        }
                    }
                }
            }
        }
    }


    @Transactional
    public void update() throws IOException {
        PaperExample paperExample = new PaperExample();

        List<Paper> papers = paperMapper.selectByExample(paperExample);


        for (Paper paper : papers){

            Dataset dataset = datasetMapper.selectByPrimaryKey(paper.getDatasetId());
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
            }else if("SciTail".equals(datasetName)) {
                taskName = "scitail";
            }


            ModelExample modelExample = new ModelExample();
            ModelExample.Criteria criteria = modelExample.createCriteria();
            criteria.andPaperIdEqualTo(paper.getPaperId());

            List<Model> models = modelMapper.selectByExample(modelExample);
            List<String> f = new ArrayList<>();
            List<String> p = new ArrayList<>();
            float maxParams = 0;
            for (Model model :models){
                f.add(String.valueOf(model.getModelFlops()));
                p.add(String.valueOf(model.getModelRemark()));
                if (model.getModelParams() > maxParams)
                    maxParams = model.getModelParams();
            }

            paper.setPaperDescription(String.valueOf(maxParams));
            String []arg = new String[8+f.size()+p.size()];
            arg[0] = "python";
            arg[1] = "-W";
            arg[2] = "ignore";
            arg[3] = "/elue_score.py";
            arg[4] = "--task_name";
            arg[5] = taskName;
            arg[6] = "--flops_submitted_by_user";
            for (int i = 7;i<7+f.size();i++){
                arg[i] = f.get(i-7);
            }
            arg[7+f.size()] = "--perfs_submitted_by_user";
            for (int i = 8+f.size();i<8+f.size()+p.size();i++){
                arg[i] = p.get(i-8-f.size());
            }
            System.out.println(Arrays.toString(arg));
            Process pr = Runtime.getRuntime().exec(arg);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            line = bufferedReader.readLine();

            paper.setPaperScore(Float.parseFloat(line));

            paperMapper.updateByPrimaryKey(paper);
        }
    }
}
