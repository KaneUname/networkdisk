package com.nwd.mapper;

import com.nwd.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wk
 * @since 2023-11-15 03:57:54
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    Map<String,Object> selectMapById(Long id);

    List<User> queryList();
}
