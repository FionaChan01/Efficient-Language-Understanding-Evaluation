package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.DataServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataController {
   @Autowired
   DataServiceImpl dataService;


   @RequestMapping("/getPaperByDataset")
   JSONObject getPaperByDataset(@RequestParam("datasetId")Integer datasetId){
      return dataService.getPaperByDataset(datasetId);
   }

   @RequestMapping("/getSubmissionByDataset")
   JSONObject getSubmissionByDataset(@RequestParam("datasetId")Integer datasetId){
      return dataService.getSubmissionByDataset(datasetId);
   }

   @RequestMapping("/getModelByPaper")
   JSONObject getModelByPaper(@RequestParam("paperId")Integer paperId){
      return dataService.getModelByPaper(paperId);
   }

   @RequestMapping("/getModelByPaperList")
   JSONObject getModelByPaper(@RequestParam("paperList") String paperList){
      JSONArray jsonArray = new JSONArray( Arrays.asList(paperList.split(",")));
      return dataService.getModelByPaperList(jsonArray);
   }

   @RequestMapping("/getSubmitBySubmissionList")
   JSONObject getSubmitBySubmissionList(@RequestParam("submissionList") String submissionList){
      JSONArray jsonArray = new JSONArray((Arrays.asList(submissionList.split(","))));
      return dataService.getSubmitBySubmissionList(jsonArray);
   }

   @RequestMapping("/getModelPerformance")
   JSONObject getModelPerformance(@RequestParam("datasetList")String datasetList,
                                  @RequestParam("kind") String kind,
                                  @RequestParam("mode") Boolean mode){
      JSONArray datasets = new JSONArray((Arrays.asList(datasetList.split(","))));
      return dataService.getModelPerformance(datasets,kind,mode);
   }

   @RequestMapping("/getSubmitPerformance")
   JSONObject getSubmitPerformance(@RequestParam("datasetList")String datasetList,
                                  @RequestParam("kind") String kind,
                                   @RequestParam("mode") Boolean mode){
      JSONArray datasets = new JSONArray((Arrays.asList(datasetList.split(","))));
      return dataService.getSubmitPerformance(datasets,kind,mode);
   }


   @RequestMapping("/getModelByToken")
   JSONObject getModelByEmail(@RequestParam("token")String token){
      return dataService.getModelByToken(token);

   }

   @RequestMapping("/deleteModelById")
   JSONObject deleteModelByID(@RequestParam("id")Integer id,@RequestParam("submitType")String submitType){
      return dataService.deleteModelByID(id,submitType);
   }

   @RequestMapping("/deleteModelsByIdList")
   JSONObject deleteModelsByIdList(@RequestParam("idList")String idList,
                                   @RequestParam("submitTypeList") String submitTypeList){
      JSONArray ids = new JSONArray((Arrays.asList(idList.split(","))));
      JSONArray submitTypes = new JSONArray((Arrays.asList(submitTypeList.split(","))));
      return dataService.deleteModelsByIdList(ids,submitTypes);
   }
}
