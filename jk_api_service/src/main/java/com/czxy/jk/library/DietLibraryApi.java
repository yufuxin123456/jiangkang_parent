package com.czxy.jk.library;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 膳食库
 */
@Api(value = "膳食表" , description = "人群中膳食的使用")
public interface DietLibraryApi {


    @ApiOperation("膳食查询")
    public BaseResult dietAll(Page page);

    @ApiOperation("膳食编辑<查询>" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value = "唯一标识",required=true,paramType="path",dataType="String")
    })
    public  BaseResult dietFindByCode(String code);

    @ApiOperation("膳食编辑<修改>" )
    public  BaseResult dietEdit(DietLibrary dietLibrary);

    @ApiOperation("膳食添加" )
    public  BaseResult dietAdd(DietLibrary dietLibrary);

    @ApiOperation("膳食删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value = "唯一标识",required=true,paramType="path",dataType="int")
    })
    public  BaseResult dietLibraryDeleteByMPId(Integer code);

}
