package com.nwd.service;

import com.nwd.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nwd.util.Result;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wk
 * @since 2023-11-15 03:57:54
 */
public interface UserService extends IService<User> {
    Map<String,Object> selectMapById(Long id);

    Result<User> queryUser(String username);

    Result<User> queryAllUser();


}
