package cn.cqu.vspace.service.impl;

import cn.cqu.vspace.mapper.UserMapper;
import cn.cqu.vspace.pojo.User;
import cn.cqu.vspace.pojo.UserExample;
import cn.cqu.vspace.service.LoginService;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sun.javafx.collections.MappingChange;
import org.apache.dubbo.config.annotation.Service;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    UserMapper userMapper;



    @Override
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

    @Override
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
