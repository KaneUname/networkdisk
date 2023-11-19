package com.nwd.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getCountTest(){
        // 查询总记录书
        //SELECT COUNT( * ) AS total FROM nwd_user
        long count = userService.count();
        System.out.println("总记录数："+count);
    }

    @Test
    public void selectMapByIdTest(){
        Long l = 1724801362308403202L;
        Map<String, Object> m = userService.selectMapById(l);
        System.out.println(m);
    }
}