package com.example.demo.controller;



import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.LoginServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Autowired
    LoginServiceImp loginServiceImp;

   @RequestMapping("/signup")
    JSONObject signup(@RequestParam("email") String email, @RequestParam("username") String username,
                      @RequestParam("pwd") String pwd){
       return loginServiceImp.signup(email,username,pwd);

   }

   @RequestMapping("/login")
    JSONObject login(@RequestParam("email") String email, @RequestParam("pwd")String pwd){
       return loginServiceImp.login(email,pwd);
   }

}
