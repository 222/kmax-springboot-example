package com.kmax.example.service;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.error.AppError;
import com.kmax.example.error.AppException;
import com.kmax.example.mapper.TaskSentenceMapper;
import com.kmax.example.model.TaskSentence;
import com.kmax.example.param.req.TaskSentenceQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 任务文本
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:25
 */
@Service
public class TaskSentenceService {

    @Resource
    private TaskSentenceMapper taskSentenceMapper;

    public Page<TaskSentence> search(TaskSentenceQuery query) {
        List<TaskSentence> results = taskSentenceMapper.search(query);
        return new Page<>(results);
    }

    @Transactional(rollbackFor = Exception.class)
    public TaskSentence add(TaskSentence taskSentence) {
        int result = taskSentenceMapper.insert(taskSentence);
        if (result == 0) {
            throw new AppException(AppError.ADD_FAILED);
        }
        return taskSentenceMapper.selectById(taskSentence.getSentenceId());
    }

    @Transactional(rollbackFor = Exception.class)
    public TaskSentence update(TaskSentence taskSentence) {
        int result = taskSentenceMapper.update(taskSentence);
        if (result == 0) {
            throw new AppException(AppError.UPDATE_FAILED);
        }
        return taskSentenceMapper.selectById(taskSentence.getSentenceId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(DeleteIds deleteIds) {
        int result = taskSentenceMapper.deleteById(deleteIds.getIds());
        if (result == 0) {
            throw new AppException(AppError.DELETE_FAILED);
        }
    }
}
