package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.demo.dao.DatasetMapper;
import com.example.demo.dao.TaskMapper;
import com.example.demo.entity.DatasetExample;
import com.example.demo.entity.TaskExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImp {
    @Autowired
    TaskMapper taskMapper;

    @Autowired
    DatasetMapper datasetMapper;


    public JSONObject all() {
        JSONObject jsonObject = new JSONObject();

        try {
            TaskExample taskExample = new TaskExample();
            jsonObject.put("tasklist",taskMapper.selectByExample(taskExample));
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }

    }

    public JSONObject tokenAll() {
        JSONObject jsonObject = new JSONObject();

        try {
            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria= taskExample.createCriteria();
            criteria.andTaskClassEqualTo("token level");
            jsonObject.put("tasklist",taskMapper.selectByExample(taskExample));
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }

    }


    public JSONObject sentenceAll() {
        JSONObject jsonObject = new JSONObject();

        try {
            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria= taskExample.createCriteria();
            criteria.andTaskClassEqualTo("sentence level");
            jsonObject.put("tasklist",taskMapper.selectByExample(taskExample));
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }

    }


    public JSONObject getDatasetByTask(Integer taskId) {
        JSONObject jsonObject = new JSONObject();
        try {
            DatasetExample datasetExample = new DatasetExample();
            DatasetExample.Criteria criteria = datasetExample.createCriteria();
            criteria.andTaskIdEqualTo(taskId);
            jsonObject.put("code","200");
            jsonObject.put("datasetlist",datasetMapper.selectByExample(datasetExample));
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    public JSONObject getTaskById(Integer taskId) {
        JSONObject jsonObject = new JSONObject();
        try {
            TaskExample taskExample = new TaskExample();
            TaskExample.Criteria criteria = taskExample.createCriteria();
            criteria.andTaskIdEqualTo(taskId);
            jsonObject.put("task",taskMapper.selectByExample(taskExample).get(0));
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }

    public JSONObject getDatasetByTaskList(JSONArray taskList) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            for (Object o : taskList) {
                int id = Integer.parseInt(o.toString());
                DatasetExample datasetExample = new DatasetExample();
                DatasetExample.Criteria criteria = datasetExample.createCriteria();
                criteria.andTaskIdEqualTo(id);
                jsonArray.add(datasetMapper.selectByExample(datasetExample));
            }
            jsonObject.put("code","200");
            jsonObject.put("datasetList",jsonArray);
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


}
