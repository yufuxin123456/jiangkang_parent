package com.czxy.jk.mapper;

import com.czxy.jk.appointment.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppointmentMapper extends tk.mybatis.mapper.common.Mapper<Appointment> {

    @Select("SELECT * FROM appointment WHERE  profileid LIKE #{s}  OR  membername LIKE  #{s}  OR phone LIKE  #{s} ")
    List<Appointment> findByMemberName(@Param("s") String s);

    /**
     *  2 为确认预约
     *  1 未确认预约
     * @param aid
     * @return
     */
    @Select("UPDATE appointment SET atype = '2' WHERE aid = #{aid}")
    Integer confirm(@Param("aid") Integer aid);
}
