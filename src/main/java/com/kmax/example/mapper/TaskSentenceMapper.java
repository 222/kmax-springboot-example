package com.kmax.example.mapper;

import com.kmax.example.model.TaskSentence;
import com.kmax.example.param.req.TaskSentenceQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务文本(TaskSentence)
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:25
 */
@Mapper
public interface TaskSentenceMapper {

    TaskSentence selectById(Integer sentenceId);

    List<TaskSentence> search(TaskSentenceQuery query);

    int insert(TaskSentence taskSentence);

    int inserts(@Param("list") List<TaskSentence> list);

    int update(TaskSentence taskSentence);

    int updates(@Param("list") List<TaskSentence> list);

    int deleteById(@Param("ids") List<Integer> ids);

    boolean exist(String field);
}

