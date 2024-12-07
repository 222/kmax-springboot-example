package com.kmax.example.service;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.error.AppError;
import com.kmax.example.error.AppException;
import com.kmax.example.mapper.TaskMemberMapper;
import com.kmax.example.model.TaskMember;
import com.kmax.example.param.req.TaskMemberQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 任务成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Service
public class TaskMemberService {

    @Resource
    private TaskMemberMapper taskMemberMapper;

    public Page<TaskMember> search(TaskMemberQuery query) {
        List<TaskMember> results = taskMemberMapper.search(query);
        return new Page<>(results);
    }

    @Transactional(rollbackFor = Exception.class)
    public TaskMember add(TaskMember taskMember) {
        int result = taskMemberMapper.insert(taskMember);
        if (result == 0) {
            throw new AppException(AppError.ADD_FAILED);
        }
        return taskMemberMapper.selectById(taskMember.getTaskMemberId());
    }

    @Transactional(rollbackFor = Exception.class)
    public TaskMember update(TaskMember taskMember) {
        int result = taskMemberMapper.update(taskMember);
        if (result == 0) {
            throw new AppException(AppError.UPDATE_FAILED);
        }
        return taskMemberMapper.selectById(taskMember.getTaskMemberId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(DeleteIds deleteIds) {
        int result = taskMemberMapper.deleteById(deleteIds.getIds());
        if (result == 0) {
            throw new AppException(AppError.DELETE_FAILED);
        }
    }
}
