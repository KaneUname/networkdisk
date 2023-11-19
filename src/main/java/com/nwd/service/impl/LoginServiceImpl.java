package com.nwd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwd.entity.LoginUser;
import com.nwd.mapper.LoginMapper;
import com.nwd.service.LoginService;
import com.nwd.util.JwtUtil;
import com.nwd.util.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, LoginUser> implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    private Result<LoginUser> result =new Result<>();

    private QueryWrapper<LoginUser> queryWrapper = new QueryWrapper<>();
    @Override
    public Result login(LoginUser loginUser) {
        queryWrapper.eq("username",loginUser.getUsername());
        LoginUser getLoginUser = loginMapper.selectOne(queryWrapper);
        if(getLoginUser == null){
            result.setResultFailed("用户不存在！");
            return result;
        }
        String passwd = DigestUtils.md5Hex(loginUser.getPassword()).toUpperCase();
        if(!getLoginUser.getPassword().equals(passwd)){
            result.setResultFailed("用户名或者密码错误！");
            return result;
        }
        // 设定登录成功消息
        result.setResultSuccess("登录成功！", getLoginUser);
        return result;
    }
}
