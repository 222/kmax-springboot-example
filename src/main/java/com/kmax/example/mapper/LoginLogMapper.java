package com.kmax.example.mapper;

import com.kmax.example.model.LoginLog;
import com.kmax.example.param.req.LoginLogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 登录日志(LoginLog)
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@Mapper
public interface LoginLogMapper {

    LoginLog selectById(Integer id);

    List<LoginLog> search(LoginLogQuery query);

    int insert(LoginLog loginLog);

    int inserts(@Param("list") List<LoginLog> list);

    int update(LoginLog loginLog);

    int updates(@Param("list") List<LoginLog> list);

    int deleteById(@Param("ids") List<Integer> ids);

    boolean exist(String field);
}

