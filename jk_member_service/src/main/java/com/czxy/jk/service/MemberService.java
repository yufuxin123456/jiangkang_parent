package com.czxy.jk.service;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import com.czxy.jk.mapper.MemberMapper;
import com.czxy.jk.member.MemberProfile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public PageInfo<MemberProfile> memberAll(Page page) {
        if (page.getPageNum()<=0){
            page.setPageNum(1);
        }
        if (page.getPageSize()<=0){
            page.setPageSize(5);
        }
        PageHelper.startPage(page.getPageNum() , page.getPageSize());

        if (page.getName()==null || "".equals(page.getName())){
            List<MemberProfile> list = memberMapper.selectAll();
            return new PageInfo<>(list);
        }else {
            List<MemberProfile> list = memberMapper.findByMemberName("%"+page.getName()+"%");
            return new PageInfo<>(list);
        }

    }

    public MemberProfile memberFindBy(Integer mpid) {
        return memberMapper.selectByPrimaryKey(mpid);
    }

    public BaseResult memberEdit(MemberProfile memberProfile) {
        int i = memberMapper.updateByPrimaryKeySelective(memberProfile);
        if (i==1){
            return BaseResult.ok("修改成功");
        }else {
            return BaseResult.error("修改失败");

        }
    }

 
    public BaseResult memberAdd(MemberProfile memberProfile) {
        int i = memberMapper.insert(memberProfile);
        if (i==1){
            return BaseResult.ok("添加成功");
        }else {
            return BaseResult.error("添加失败");

        }
    }

    public BaseResult memberDeleteByMPId(Integer mpid) {
        int i = memberMapper.deleteByPrimaryKey(mpid);
        if (i==1){
            return BaseResult.ok("删除成功");
        }else {
            return BaseResult.error("删除失败");
        }
    }
}
