package com.czxy.jk.library;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "运动" , description = "加油")
public interface MotionLibraryApi {

    @ApiOperation("运动查询")
    public BaseResult motionAll(Page page);

    @ApiOperation("运动编辑<查询>" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value = "唯一标识",required=true,paramType="path",dataType="String")
    })
    public  BaseResult motionFindByCode(String code);

    @ApiOperation("运动编辑<修改>" )
    public  BaseResult motionEdit(DietLibrary dietLibrary);

    @ApiOperation("运动添加" )
    public  BaseResult motionAdd(DietLibrary dietLibrary);

    @ApiOperation("运动删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value = "唯一标识",required=true,paramType="path",dataType="int")
    })
    public  BaseResult motionLibraryDeleteByMPId(Integer code);

}
