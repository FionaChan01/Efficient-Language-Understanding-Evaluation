package cn.cqu.vspace.conroller;
import cn.cqu.vspace.service.DataService;
import cn.cqu.vspace.service.TaskService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataController {
   @Reference
   DataService dataService;


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
                                  @RequestParam("kind") String kind){
      JSONArray datasets = new JSONArray((Arrays.asList(datasetList.split(","))));
      return dataService.getModelPerformance(datasets,kind);
   }

   @RequestMapping("/getSubmitPerformance")
   JSONObject getSubmitPerformance(@RequestParam("datasetList")String datasetList,
                                  @RequestParam("kind") String kind){
      JSONArray datasets = new JSONArray((Arrays.asList(datasetList.split(","))));
      return dataService.getSubmitPerformance(datasets,kind);
   }


   @RequestMapping("/getModelByToken")
   JSONObject getModelByEmail(@RequestParam("token")String token){
      return dataService.getModelByToken(token);

   }

   @RequestMapping("/deleteModelById")
   JSONObject deleteModelByID(@RequestParam("id")Integer id,@RequestParam("submitType")String submitType){
      return dataService.deleteModelByID(id,submitType);
   }
}
