package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface DataService {
    JSONObject getPaperByDataset(Integer datasetId);
    JSONObject getSubmissionByDataset(Integer datasetId);
    JSONObject getModelByPaper(Integer paperId);
    JSONObject getModelByPaperList(JSONArray paperList);
    JSONObject getSubmitBySubmissionList(JSONArray paperList);
    JSONObject getModelPerformance(JSONArray datasetList,String kind);
    JSONObject getSubmitPerformance(JSONArray datasetList,String kind);
    JSONObject getModelByToken(String token);
    JSONObject deleteModelByID(Integer id,String submitType);
}
