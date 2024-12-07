package com.kmax.example.controller;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.common.Response;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import com.kmax.example.model.LoginLog;
import com.kmax.example.param.req.LoginLogQuery;
import com.kmax.example.service.LoginLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 登录日志
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:22
 */
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    /**
     * 分页查询
     *
     * @param query 分页参数
     * @return 登录日志列表
     */
    @PostMapping("/search")
    public Response<Page<LoginLog>> search(@Valid @RequestBody LoginLogQuery query) {
        Page<LoginLog> result = loginLogService.search(query);
        return Response.success(result);
    }

    /**
     * 新增登录日志
     *
     * @param loginLog 登录日志参数
     * @return 登录日志
     */
    @PostMapping("/add")
    public Response<LoginLog> add(@Validated(INSERT.class) @RequestBody LoginLog loginLog) {
        LoginLog result = loginLogService.add(loginLog);
        return Response.success(result);
    }

    /**
     * 修改登录日志
     *
     * @param loginLog 登录日志参数
     * @return 登录日志
     */
    @PostMapping("/update")
    public Response<LoginLog> update(@Validated(UPDATE.class) @RequestBody LoginLog loginLog) {
        LoginLog result = loginLogService.update(loginLog);
        return Response.success(result);
    }

    /**
     * 删除登录日志
     *
     * @param deleteIds 删除ids
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Response<Void> deleteById(@Validated @RequestBody DeleteIds deleteIds) {
        loginLogService.deleteById(deleteIds);
        return Response.success();
    }

}

