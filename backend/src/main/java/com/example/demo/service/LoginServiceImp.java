package com.example.demo.service;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImp  {

    @Autowired
    UserMapper userMapper;




    public JSONObject login(String email, String pwd) {
        JSONObject jsonObject = new JSONObject();
        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andEmailEqualTo(email);
            User user = userMapper.selectByExample(userExample).get(0);
            if (pwd.equals(user.getPwd())){
                String token = TokenUtil.token(email,pwd);
                jsonObject.put("token",token);
                jsonObject.put("username",user.getUsername());
                jsonObject.put("code","200");
            }else {
                jsonObject.put("code","201");
                jsonObject.put("token","");
            }
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");
            return jsonObject;
        }
    }


    public JSONObject signup(String email, String username, String pwd) {
        JSONObject jsonObject = new JSONObject();

        try {
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPwd(pwd);
            userMapper.insert(user);
            jsonObject.put("code","200");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("code","500");

            return jsonObject;
        }


    }
}
