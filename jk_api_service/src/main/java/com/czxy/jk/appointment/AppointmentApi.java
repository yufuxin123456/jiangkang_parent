package com.czxy.jk.appointment;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="预约管理",description = "预约管理_预约列表")
public interface AppointmentApi {

    @ApiOperation("列表预约查询")
    public BaseResult selectAll(Page page);

    @ApiOperation("添加预约列表")
    public  BaseResult appointmentAdd(Appointment appointment);


    @ApiOperation("确认预约")
    @ApiImplicitParam(name="aid",value = "唯一标识",required=true,paramType="path",dataType="int")
    public  BaseResult confirm(Integer aid);

    @ApiOperation("取消预约")
    @ApiImplicitParam(name="aid",value = "唯一标识",required=true,paramType="path",dataType="int")
    public  BaseResult cancel(Integer aid);


}
