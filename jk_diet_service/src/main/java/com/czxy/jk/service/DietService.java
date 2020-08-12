package com.czxy.jk.service;

import com.czxy.jk.common.Page;
import com.czxy.jk.library.DietLibrary;
import com.czxy.jk.mapper.DietMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DietService {

    @Resource
    private DietMapper dietMapper;

    public PageInfo<DietLibrary> dietAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        if (page.getPageNum()<=0){
            page.setPageNum(1);
        }
        if (page.getPageSize()<=0){
            page.setPageSize(5);
        }
        PageHelper.startPage(page.getPageNum() , page.getPageSize());

        if (page.getName()!=null && "".equals(page.getName())){
            List<DietLibrary> list = dietMapper.selectAll();
            return new PageInfo<DietLibrary>(list);
        }else {
            List<DietLibrary> list = dietMapper.findByMemberName(page.getName()+"%");
            return new PageInfo<DietLibrary>(list);
        }

    }

    public DietLibrary dietFindByCode(String code) {
        return dietMapper.selectByPrimaryKey(code);
    }

    public Integer dietEdit(DietLibrary dietLibrary) {
        int i = dietMapper.updateByPrimaryKeySelective(dietLibrary);
        return i;
    }

    public Integer dietAdd(DietLibrary dietLibrary) {
        //id不是自增的
        return dietMapper.insert(dietLibrary);
    }

    public Integer dietLibraryDeleteByMPId(Integer code) {
        return dietMapper.deleteByPrimaryKey(code);
    }
}
