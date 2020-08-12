package com.czxy.jk.dao;


import com.czxy.jk.login.Login;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;


@org.apache.ibatis.annotations.Mapper
public interface LoginMapper extends Mapper<Login> {

    @Select("select * from login where username = #{username} and password = #{password}")
    Login login(Login login);
}
