package com.nwd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nwd.entity.LoginUser;
import com.nwd.entity.User;
import com.nwd.util.Result;

public interface LoginService extends IService<LoginUser> {

    //用户登录
    Result<LoginUser> login(LoginUser loginUser);
}
