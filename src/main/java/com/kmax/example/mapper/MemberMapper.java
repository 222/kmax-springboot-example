package com.kmax.example.mapper;

import com.kmax.example.model.Member;
import com.kmax.example.param.req.MemberQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 成员(Member)
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@Mapper
public interface MemberMapper {

    Member selectById(Integer memberId);

    List<Member> search(MemberQuery query);

    int insert(Member member);

    int inserts(@Param("list") List<Member> list);

    int update(Member member);

    int updates(@Param("list") List<Member> list);

    int deleteById(@Param("ids") List<Integer> ids);

    boolean exist(String field);
}

