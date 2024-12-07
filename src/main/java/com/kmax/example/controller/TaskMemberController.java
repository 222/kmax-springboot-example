package com.kmax.example.controller;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.common.Response;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import com.kmax.example.model.TaskMember;
import com.kmax.example.param.req.TaskMemberQuery;
import com.kmax.example.service.TaskMemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 任务成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@RestController
@RequestMapping("/taskMember")
public class TaskMemberController {

    @Resource
    private TaskMemberService taskMemberService;

    /**
     * 分页查询
     *
     * @param query 分页参数
     * @return 任务成员列表
     */
    @PostMapping("/search")
    public Response<Page<TaskMember>> search(@Valid @RequestBody TaskMemberQuery query) {
        Page<TaskMember> result = taskMemberService.search(query);
        return Response.success(result);
    }

    /**
     * 新增任务成员
     *
     * @param taskMember 任务成员参数
     * @return 任务成员
     */
    @PostMapping("/add")
    public Response<TaskMember> add(@Validated(INSERT.class) @RequestBody TaskMember taskMember) {
        TaskMember result = taskMemberService.add(taskMember);
        return Response.success(result);
    }

    /**
     * 修改任务成员
     *
     * @param taskMember 任务成员参数
     * @return 任务成员
     */
    @PostMapping("/update")
    public Response<TaskMember> update(@Validated(UPDATE.class) @RequestBody TaskMember taskMember) {
        TaskMember result = taskMemberService.update(taskMember);
        return Response.success(result);
    }

    /**
     * 删除任务成员
     *
     * @param deleteIds 删除ids
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Response<Void> deleteById(@Validated @RequestBody DeleteIds deleteIds) {
        taskMemberService.deleteById(deleteIds);
        return Response.success();
    }

}

