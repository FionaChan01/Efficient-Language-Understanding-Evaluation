package cn.cqu.vspace.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface SubmitService {
    JSONObject submitPaper(String codeUrl, String modelName, String paperTitle, String paperUrl, String token,
                           Integer datasetId,JSONArray flops,JSONArray params,JSONArray remark);
    JSONObject submitSubmission(Integer datasetId, MultipartFile[] files, JSONArray flops, JSONArray params,
                                String description,String affiliation,String token, String submissionName);

    JSONObject submitType2(Integer datasetId, MultipartFile[] tsvfile, MultipartFile pyfile,
                                String description,String affiliation,String token, String submissionName);
}
