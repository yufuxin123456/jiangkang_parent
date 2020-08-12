package com.czxy.jk.service;

import com.czxy.jk.common.Page;
import com.czxy.jk.dao.MotionMapper;
import com.czxy.jk.library.DietLibrary;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MotionService {

    @Resource
    private MotionMapper motionMapper;

    public PageInfo<DietLibrary> motionAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        if (page.getPageNum()<=0){
            page.setPageNum(1);
        }
        if (page.getPageSize()<=0){
            page.setPageSize(5);
        }
        PageHelper.startPage(page.getPageNum() , page.getPageSize());

        if (page.getName()!=null && "".equals(page.getName())){
            List<DietLibrary> list = motionMapper.selectAll();
            return new PageInfo<DietLibrary>(list);
        }else {
            List<DietLibrary> list = motionMapper.findByMemberName(page.getName()+"%");
            return new PageInfo<DietLibrary>(list);
        }

    }

    public DietLibrary motionFindByCode(String code) {
        return motionMapper.selectByPrimaryKey(code);
    }

    public Integer motionEdit(DietLibrary dietLibrary) {
        int i = motionMapper.updateByPrimaryKeySelective(dietLibrary);
        return i;
    }

    public Integer motionAdd(DietLibrary dietLibrary) {
        //id不是自增的
        return motionMapper.insert(dietLibrary);
    }

    public Integer motionLibraryDeleteByMPId(Integer code) {
        return motionMapper.deleteByPrimaryKey(code);
    }
}
