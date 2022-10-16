package com.example.demo.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.demo.service.SubmitServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;


//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/submit")
@CrossOrigin
public class SubmitController {
    @Autowired
    SubmitServiceImp submitService;


    @RequestMapping("/submitPaper")
    JSONObject submitPaper(@RequestParam("codeUrl")String codeUrl,
                           @RequestParam("modelName")String modelName,
                           @RequestParam("paperTitle")String paperTitle,
                           @RequestParam("paperUrl")String paperUrl,
                           @RequestParam("token")String token,
                           @RequestParam("datasetId")Integer datasetId,
                           @RequestParam("remark")String  remark,
                           @RequestParam("flops")String flops,
                           @RequestParam("params")String params){
        try {
            JSONArray r = new JSONArray(Arrays.asList(remark.split(",")));
            JSONArray f = new JSONArray(Arrays.asList(flops.split(",")));
            JSONArray p = new JSONArray(Arrays.asList(params.split(",")));
            return submitService.submitPaper(codeUrl,modelName,paperTitle,paperUrl,token,datasetId,f,p,r);
        }
        catch (Exception e){
            e.printStackTrace();
            return new JSONObject();
        }

    }

    @RequestMapping("/submitSubmission")
    JSONObject submitSubmission(@RequestParam("file") MultipartFile[] file,
                                @RequestParam("flops")String f,
                                @RequestParam("params")String p,
                                @RequestParam("modelDescription")String description,
                                @RequestParam("institute")String affiliation,
                                @RequestParam("datasetId")Integer datasetId,
                                @RequestParam("token")String token,
                                @RequestParam("submissionName")String submissionName,
                                @RequestParam("mode")String mode) throws IOException {
        JSONArray flops = new JSONArray(Arrays.asList(f.split(",")));
        JSONArray params = new JSONArray(Arrays.asList(p.split(",")));

        return submitService.submitSubmission(datasetId,file,flops,params,description,affiliation,token,submissionName,mode);
    }

    @RequestMapping("/submitType2")
    JSONObject submitSubmission(@RequestParam("tsvfile") MultipartFile[] tsvfile,
                                @RequestParam("pyfile") MultipartFile pyfile,

                                @RequestParam("modelDescription")String description,
                                @RequestParam("institute")String affiliation,
                                @RequestParam("datasetId")Integer datasetId,
                                @RequestParam("token")String token,
                                @RequestParam("submissionName")String submissionName
                                ){

        return submitService.submitType2(datasetId,tsvfile,pyfile,description,affiliation,token,submissionName);
    }

    @RequestMapping("/update")
    void update() throws IOException {
        submitService.update();
    }

}
