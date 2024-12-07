package com.kmax.example.controller;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.common.Response;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import com.kmax.example.model.TaskSentence;
import com.kmax.example.param.req.TaskSentenceQuery;
import com.kmax.example.service.TaskSentenceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 任务文本
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@RestController
@RequestMapping("/taskSentence")
public class TaskSentenceController {

    @Resource
    private TaskSentenceService taskSentenceService;

    /**
     * 分页查询
     *
     * @param query 分页参数
     * @return 任务文本列表
     */
    @PostMapping("/search")
    public Response<Page<TaskSentence>> search(@Valid @RequestBody TaskSentenceQuery query) {
        Page<TaskSentence> result = taskSentenceService.search(query);
        return Response.success(result);
    }

    /**
     * 新增任务文本
     *
     * @param taskSentence 任务文本参数
     * @return 任务文本
     */
    @PostMapping("/add")
    public Response<TaskSentence> add(@Validated(INSERT.class) @RequestBody TaskSentence taskSentence) {
        TaskSentence result = taskSentenceService.add(taskSentence);
        return Response.success(result);
    }

    /**
     * 修改任务文本
     *
     * @param taskSentence 任务文本参数
     * @return 任务文本
     */
    @PostMapping("/update")
    public Response<TaskSentence> update(@Validated(UPDATE.class) @RequestBody TaskSentence taskSentence) {
        TaskSentence result = taskSentenceService.update(taskSentence);
        return Response.success(result);
    }

    /**
     * 删除任务文本
     *
     * @param deleteIds 删除ids
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Response<Void> deleteById(@Validated @RequestBody DeleteIds deleteIds) {
        taskSentenceService.deleteById(deleteIds);
        return Response.success();
    }

}

