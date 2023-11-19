package com.nwd.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nwd.entity.LoginUser;
import com.nwd.entity.User;
import com.nwd.mapper.UserMapper;
import com.nwd.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nwd.util.Result;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wk
 * @since 2023-11-15 03:57:54
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    private Result<User> result =new Result<>();
    private QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    @Override
    public Map<String, Object> selectMapById(Long id) {
        Map<String, Object> map = userMapper.selectMapById(id);
        return map;
    }

    @Override
    public Result<User> queryUser(String username) {
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if(user==null){
            result.setResultFailed("用户不存在");
            return  result;
        }
        result.setResultSuccess("用户信息查询成功！",user);
        return result;
    }

    @Override
    public Result<User> queryAllUser() {
        Result resultUser =new Result<>();
        Collection<User> userList = userMapper.queryList();
        if(userList.size()==0){
            resultUser.setResultFailed("未查询到用户");
            return  resultUser;
        }
        resultUser.setResultSuccess("用户信息表查询成功", userList);
        return resultUser;
    }



    @Override
    public boolean saveOrUpdate(User entity, Wrapper<User> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }
}
