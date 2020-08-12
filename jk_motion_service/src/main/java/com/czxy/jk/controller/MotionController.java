package com.czxy.jk.controller;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import com.czxy.jk.library.DietLibrary;
import com.czxy.jk.library.MotionLibraryApi;
import com.czxy.jk.service.MotionService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/motion")
public class MotionController implements MotionLibraryApi {

    @Resource
    private MotionService motionService;

    @Override
    @PostMapping
    public BaseResult motionAll(Page page) {
        PageInfo<DietLibrary> info = motionService.motionAll(page);
        return BaseResult.ok("成功", info);
    }

    @Override
    @GetMapping("/code")
    public BaseResult motionFindByCode(@PathVariable("code") String code) {
        DietLibrary dietLibrary = motionService.motionFindByCode(code);
        return BaseResult.ok("成功", dietLibrary);
    }

    @Override
    @PutMapping
    public BaseResult motionEdit(DietLibrary dietLibrary) {
        Integer i = motionService.motionEdit(dietLibrary);
        if (i == 1){
            return BaseResult.ok("修改成功");

        }else {
            return BaseResult.error("修改失败");
        }

    }

    @Override
    @PostMapping("/add")
    public BaseResult motionAdd(DietLibrary dietLibrary) {
        Integer i = motionService.motionAdd(dietLibrary);
        if (i == 1){
            return BaseResult.ok("添加成功");

        }else {
            return BaseResult.error("添加失败");
        }
    }

    @Override
    @DeleteMapping
    public BaseResult motionLibraryDeleteByMPId(Integer code) {
        Integer i = motionService.motionLibraryDeleteByMPId(code);
        if (i == 1){
            return BaseResult.ok("删除成功");

        }else {
            return BaseResult.error("删除失败");
        }
    }
}
