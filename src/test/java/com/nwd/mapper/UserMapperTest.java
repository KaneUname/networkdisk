package com.nwd.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nwd.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void selectList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username","admin");
        Collection<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectPage(){
        Page<User> page = new Page<>(2,2);
        IPage<User> userIPage = userMapper.selectPage(page,null);
        System.out.println("总页数"+userIPage.getPages());
        System.out.println("总记录数"+userIPage.getTotal());
        Collection<User> userRecords = userIPage.getRecords();
        userRecords.forEach(System.out::println);
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("yingzheng");
        user.setPassword("qwerutit123456");
        user.setImgurl("tx.jpg");
        user.setFullname("嬴政");
        user.setMobile("18597029453");
        user.setEmail("yingzheng@gmail.com");
        int ins = userMapper.insert(user);
        System.out.println("result:"+ins);
    }

    @Test
    public void deleteTest(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","yingzheng");
        int i = userMapper.delete(queryWrapper);
        System.out.println(i);
    }

    @Test
    public void zdyQuery(){
        Long id = 1724779428413734915L;
        Map<String, Object> map = userMapper.selectMapById(id);
        System.out.println(map);
    }

}