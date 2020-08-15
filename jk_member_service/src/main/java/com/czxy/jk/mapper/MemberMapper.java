package com.czxy.jk.mapper;

import com.czxy.jk.member.MemberProfile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MemberMapper extends Mapper<MemberProfile> {

    @Select("SELECT * FROM member_profile WHERE username like #{name} or id like #{name} ")
    List<MemberProfile> findByMemberName(@Param("name") String name);



}
