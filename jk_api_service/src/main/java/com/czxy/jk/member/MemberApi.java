package com.czxy.jk.member;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "会员" , description = "会员")
public interface MemberApi {

    @ApiOperation("会员查询")
    public BaseResult memberAll( Page page);

    @ApiOperation("会员编辑<查询>" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="mpid",value = "唯一标识",required=true,paramType="path",dataType="int")
    })
    public  BaseResult memberFindBy(Integer mpid);

    @ApiOperation("会员编辑<修改>" )
    public  BaseResult memberEdit(MemberProfile memberProfile);

    @ApiOperation("会员添加" )
    public  BaseResult memberAdd(MemberProfile memberProfile);

    @ApiOperation("会员删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="mpid",value = "唯一标识",required=true,paramType="path",dataType="int")
    })
    public  BaseResult memberDeleteByMPId(Integer mpid);
}
