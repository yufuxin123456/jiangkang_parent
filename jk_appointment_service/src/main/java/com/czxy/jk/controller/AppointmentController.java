package com.czxy.jk.controller;

import com.czxy.jk.BaseResult;
import com.czxy.jk.appointment.Appointment;
import com.czxy.jk.appointment.AppointmentApi;
import com.czxy.jk.common.Page;
import com.czxy.jk.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/appointment")
public class AppointmentController implements AppointmentApi {


    @Resource
    private AppointmentService appointmentService;


    @Override
    @PostMapping
    public BaseResult selectAll(Page page) {
        return appointmentService.selectAll(page);
    }

    @Override
    @PostMapping()
    public BaseResult appointmentAdd(Appointment appointment) {
        return appointmentService.appointmentAdd(appointment);
    }

    @Override
    @GetMapping("/confirm/{aid}")
    public BaseResult confirm(@PathVariable("aid") Integer aid) {
        return appointmentService.confirm(aid);
    }

    @Override
    @DeleteMapping
    public BaseResult cancel(Integer aid) {
        return appointmentService.cancel(aid);
    }
}
