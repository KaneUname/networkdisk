package com.nwd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nwd.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2023-11-15 03:57:54
 */
@Mapper
public interface LoginMapper extends BaseMapper<LoginUser> {
   public LoginUser selectLoginUser(LoginUser loginUser);
}
