package com.czxy.jk.service;

import com.czxy.jk.BaseResult;
import com.czxy.jk.appointment.Appointment;
import com.czxy.jk.common.Page;
import com.czxy.jk.mapper.AppointmentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;


    public BaseResult selectAll(Page page) {
        if (page.getPageNum()<=0){
            page.setPageNum(1);
        }
        if (page.getPageSize()<=0){
            page.setPageSize(5);
        }
        PageHelper.startPage(page.getPageNum() , page.getPageSize());

        if (page.getName()!=null && "".equals(page.getName())){
            List<Appointment> list = appointmentMapper.selectAll();
            return BaseResult.ok("成功",new PageInfo<Appointment>(list));
        }else {
            List<Appointment> list = appointmentMapper.findByMemberName("'%"+page.getName()+"%'");
            return  BaseResult.ok("成功",new PageInfo<Appointment>(list));
        }

    }

    public BaseResult appointmentAdd(Appointment appointment) {
        return BaseResult.ok("成功",appointmentMapper.insert(appointment));
    }

    public BaseResult confirm(Integer aid) {
        Integer x = appointmentMapper.confirm(aid);
        if (x==1){
            return BaseResult.ok("成功",x);

        }else {
            return BaseResult.error("失败");

        }
    }

    public BaseResult cancel(Integer aid) {
        int i = appointmentMapper.deleteByPrimaryKey(aid);
        if (i==1){
            return BaseResult.ok("成功",i);

        }else {
            return BaseResult.error("失败");

        }
    }
}
