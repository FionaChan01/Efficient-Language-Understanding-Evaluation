package cn.cqu.vspace.service;


import com.alibaba.fastjson.JSONObject;

public interface LoginService {
    JSONObject login(String email,String pwd);
    JSONObject signup(String email,String username,String pwd);
}
