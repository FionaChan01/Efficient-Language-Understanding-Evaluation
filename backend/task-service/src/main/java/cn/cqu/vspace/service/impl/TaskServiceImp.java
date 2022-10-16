package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.DatasetMapper;
import cn.cqu.vspace.mapper.TaskMapper;
import cn.cqu.vspace.pojo.Dataset;
import cn.cqu.vspace.pojo.DatasetExample;
import cn.cqu.vspace.pojo.TaskExample;
import cn.cqu.vspace.service.TaskService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Autowired
    DatasetMapper datasetMapper;

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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
