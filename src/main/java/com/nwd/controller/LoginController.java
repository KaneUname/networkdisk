package com.nwd.controller;

import com.nwd.entity.LoginUser;
import com.nwd.entity.User;
import com.nwd.service.LoginService;
import com.nwd.util.JwtUtil;
import com.nwd.util.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Result<LoginUser> login(@RequestBody LoginUser user , HttpServletResponse response){
        Result<LoginUser> login = loginService.login(user);
        LoginUser data = (LoginUser)login.getData();
        if(data!=null){
            response.setHeader("authorization",JwtUtil.createToken(data));
        }
        return login;
    }
}
