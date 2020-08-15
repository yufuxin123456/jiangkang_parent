package com.czxy.jk.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private Integer pageNum; // 第几页
    private Integer pageSize;// 一页多少条
    private String name;

}

