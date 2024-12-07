package com.kmax.example.mapper;

import com.kmax.example.model.TaskMember;
import com.kmax.example.param.req.TaskMemberQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务成员(TaskMember)
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Mapper
public interface TaskMemberMapper {

    TaskMember selectById(Integer taskMemberId);

    List<TaskMember> search(TaskMemberQuery query);

    int insert(TaskMember taskMember);

    int inserts(@Param("list") List<TaskMember> list);

    int update(TaskMember taskMember);

    int updates(@Param("list") List<TaskMember> list);

    int deleteById(@Param("ids") List<Integer> ids);

    boolean exist(String field);
}

