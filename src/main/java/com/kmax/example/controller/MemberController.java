package com.kmax.example.controller;

import com.kmax.example.common.DeleteIds;
import com.kmax.example.common.Page;
import com.kmax.example.common.Response;
import com.kmax.example.common.validation.group.INSERT;
import com.kmax.example.common.validation.group.UPDATE;
import com.kmax.example.model.Member;
import com.kmax.example.param.req.MemberQuery;
import com.kmax.example.service.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 成员
 *
 * @author youping.tan
 * @since 2024-12-01 20:25:23
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 分页查询
     *
     * @param query 分页参数
     * @return 成员列表
     */
    @PostMapping("/search")
    public Response<Page<Member>> search(@Valid @RequestBody MemberQuery query) {
        Page<Member> result = memberService.search(query);
        return Response.success(result);
    }

    /**
     * 新增成员
     *
     * @param member 成员参数
     * @return 成员
     */
    @PostMapping("/add")
    public Response<Member> add(@Validated(INSERT.class) @RequestBody Member member) {
        Member result = memberService.add(member);
        return Response.success(result);
    }

    /**
     * 修改成员
     *
     * @param member 成员参数
     * @return 成员
     */
    @PostMapping("/update")
    public Response<Member> update(@Validated(UPDATE.class) @RequestBody Member member) {
        Member result = memberService.update(member);
        return Response.success(result);
    }

    /**
     * 删除成员
     *
     * @param deleteIds 删除ids
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Response<Void> deleteById(@Validated @RequestBody DeleteIds deleteIds) {
        memberService.deleteById(deleteIds);
        return Response.success();
    }

}

