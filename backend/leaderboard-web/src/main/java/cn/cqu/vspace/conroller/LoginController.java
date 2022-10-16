package cn.cqu.vspace.conroller;



import cn.cqu.vspace.service.LoginService;


import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.*;

//使用dubbo注解远程调用user-service
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
    @Reference
    LoginService loginService;

   @RequestMapping("/signup")
    JSONObject signup(@RequestParam("email") String email, @RequestParam("username") String username,
                      @RequestParam("pwd") String pwd){
       return loginService.signup(email,username,pwd);

   }

   @RequestMapping("/login")
    JSONObject login(@RequestParam("email") String email, @RequestParam("pwd")String pwd){
       return loginService.login(email,pwd);
   }

}
