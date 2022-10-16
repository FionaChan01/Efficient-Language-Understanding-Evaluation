package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface TaskService {

    JSONObject all();
    JSONObject tokenAll();
    JSONObject sentenceAll();
    JSONObject getDatasetByTask(Integer taskId);
    JSONObject getTaskById(Integer taskId);
    JSONObject getDatasetByTaskList(JSONArray taskList);
}
