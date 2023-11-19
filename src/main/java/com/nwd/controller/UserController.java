package com.nwd.controller;


import com.nwd.entity.User;
import com.nwd.service.UserService;
import com.nwd.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findByUser/{username}")
    public Result<User> findByUser(@PathVariable("username") String username, HttpServletResponse response){
        Result<User> resultUser = userService.queryUser(username);
        return resultUser;
    }


    /**
     *查询所有人员信息
     * @return
     */
    @GetMapping("/findAll")
    public Result<User> findAll(HttpServletResponse response){
        Result<User> userResult = userService.queryAllUser();
        return userResult;
    }

}
