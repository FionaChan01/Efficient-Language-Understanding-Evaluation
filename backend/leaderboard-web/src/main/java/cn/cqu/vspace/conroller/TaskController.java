package cn.cqu.vspace.conroller;


import cn.cqu.vspace.service.TaskService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
    @Reference
    TaskService taskService;

    @RequestMapping("/all")
    JSONObject all(){
        return taskService.all();
    }

    @RequestMapping("/tokenAll")
    JSONObject tokenAll(){
        return taskService.tokenAll();
    }

    @RequestMapping("/sentenceAll")
    JSONObject sentenceAll(){
        return taskService.sentenceAll();
    }

    @RequestMapping("/getDatasetByTask")
    JSONObject getDatasetByTask(@RequestParam("taskId") Integer taskId){
        return taskService.getDatasetByTask(taskId);
    }

    @RequestMapping("/getTaskById")
    JSONObject getTaskById(@RequestParam("taskId") Integer taskId){
        return taskService.getTaskById(taskId);
    }

    @RequestMapping("/getDatasetByTaskList")
    JSONObject getDatasetByTaskList(@RequestParam("taskList") String taskList){
        JSONArray tasks = new JSONArray(Arrays.asList(taskList.split(",")));
        return taskService.getDatasetByTaskList(tasks);
    }
}
