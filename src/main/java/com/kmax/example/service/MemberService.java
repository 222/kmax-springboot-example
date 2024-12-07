package com.kmax.example.service;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.error.AppError;
import com.kmax.example.error.AppException;
import com.kmax.example.mapper.MemberMapper;
import com.kmax.example.model.Member;
import com.kmax.example.param.req.MemberQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * 成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:24
 */
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public Page<Member> search(MemberQuery query) {
        List<Member> results = memberMapper.search(query);
        return new Page<>(results);
    }

    @Transactional(rollbackFor = Exception.class)
    public Member add(Member member) {
        int result = memberMapper.insert(member);
        if (result == 0) {
            throw new AppException(AppError.ADD_FAILED);
        }
        return memberMapper.selectById(member.getMemberId());
    }

    @Transactional(rollbackFor = Exception.class)
    public Member update(Member member) {
        int result = memberMapper.update(member);
        if (result == 0) {
            throw new AppException(AppError.UPDATE_FAILED);
        }
        return memberMapper.selectById(member.getMemberId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(DeleteIds deleteIds) {
        int result = memberMapper.deleteById(deleteIds.getIds());
        if (result == 0) {
            throw new AppException(AppError.DELETE_FAILED);
        }
    }
}
