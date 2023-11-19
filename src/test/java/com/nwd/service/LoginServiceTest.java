package com.nwd.service;

import com.nwd.entity.LoginUser;
import com.nwd.util.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {


    @Autowired
    private LoginService loginService;

    private LoginUser loginUser = new LoginUser();

    @Test
    void login() {
        loginUser.setUsername("admin");
        loginUser.setPassword("1234563");
        Result<LoginUser> login = loginService.login(loginUser);
        System.out.println(login);
    }
}