package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.TaskServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;


@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
    @Autowired
    TaskServiceImp taskService;

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
