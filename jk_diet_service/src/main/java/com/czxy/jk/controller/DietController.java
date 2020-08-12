package com.czxy.jk.controller;

import com.czxy.jk.BaseResult;
import com.czxy.jk.common.Page;
import com.czxy.jk.library.DietLibrary;
import com.czxy.jk.library.DietLibraryApi;
import com.czxy.jk.service.DietService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/motion")
public class DietController implements DietLibraryApi {

    @Resource
    private DietService dietService;

    @Override
    @PostMapping
    public BaseResult dietAll(Page page) {
        PageInfo<DietLibrary> info = dietService.dietAll(page);
        return BaseResult.ok("成功", info);
    }

    @Override
    @GetMapping("/code")
    public BaseResult dietFindByCode(@PathVariable("code") String code) {
        DietLibrary dietLibrary = dietService.dietFindByCode(code);
        return BaseResult.ok("成功", dietLibrary);
    }

    @Override
    @PutMapping
    public BaseResult dietEdit(DietLibrary dietLibrary) {
        Integer i = dietService.dietEdit(dietLibrary);
        if (i == 1){
            return BaseResult.ok("修改成功");

        }else {
            return BaseResult.error("修改失败");
        }

    }

    @Override
    @PostMapping("/add")
    public BaseResult dietAdd(DietLibrary dietLibrary) {
        Integer i = dietService.dietAdd(dietLibrary);
        if (i == 1){
            return BaseResult.ok("添加成功");

        }else {
            return BaseResult.error("添加失败");
        }
    }

    @Override
    @DeleteMapping
    public BaseResult dietLibraryDeleteByMPId(Integer code) {
        Integer i = dietService.dietLibraryDeleteByMPId(code);
        if (i == 1){
            return BaseResult.ok("删除成功");

        }else {
            return BaseResult.error("删除失败");
        }
    }
}
