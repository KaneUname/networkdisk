package com.nwd.mapper;

import com.nwd.entity.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;
    private LoginUser user = new LoginUser();
    @Test
    void selectLoginUser() {
        user.setUsername("admin");
        LoginUser loginUser = loginMapper.selectLoginUser(user);
        System.out.println(loginUser.toString());
    }
}