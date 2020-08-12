package com.czxy.jk.login;

import com.czxy.jk.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(value="用户登录",description = "用户登录校验")
public interface LoginApi {

//    //页面查询
//    @ApiOperation("分页查询页面列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
//            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
//    })
//    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
//    //新增页面
//    @ApiOperation("新增页面")
//    public CmsPageResult add(CmsPage cmsPage);


    //登录
    @ApiOperation("用户登录")
    public BaseResult login( Login login);

    @ApiOperation("验证码")
    public void verifycode (String username , HttpServletResponse response) throws IOException;


}
