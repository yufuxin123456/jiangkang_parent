package com.czxy.jk.controller;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import com.czxy.jk.member.MemberApi;
import com.czxy.jk.member.MemberProfile;
import com.czxy.jk.service.MemberService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
public class MemberController implements MemberApi {

    @Resource
    private MemberService memberService;

    @PostMapping
    @Override
    public BaseResult memberAll(Page page){
        PageInfo<MemberProfile> list = memberService.memberAll(page);
        return BaseResult.ok("成功" , list);
    }

    @Override
    @GetMapping("/{mpid}")
    public BaseResult memberFindBy(@PathVariable("mpid") Integer mpid) {
        MemberProfile memberProfile = memberService.memberFindBy(mpid);
        return BaseResult.ok("成功" ,memberService.memberFindBy(mpid) );
    }

    @Override
    @PutMapping
    public BaseResult memberEdit(MemberProfile memberProfile) {
        return memberService.memberEdit(memberProfile);
    }

    @Override
    @PostMapping("/add")
    public BaseResult memberAdd(MemberProfile memberProfile) {
        return memberService.memberAdd(memberProfile);
    }

    @Override
    @DeleteMapping("/{mpid}")
    public BaseResult memberDeleteByMPId(@PathVariable("mpid") Integer mpid) {
        return memberService.memberDeleteByMPId(mpid);
    }

}
