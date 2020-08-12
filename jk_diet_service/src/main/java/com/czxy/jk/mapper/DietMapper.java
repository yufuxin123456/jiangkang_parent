package com.czxy.jk.mapper;

import com.czxy.jk.library.DietLibrary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DietMapper extends Mapper<DietLibrary> {

    @Select("SELECT * FROM motionlibrary WHERE foodname like #{name} or type like #{name} ")
    List<DietLibrary> findByMemberName(@Param("name") String s);

}
