package com.czxy.jk.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    private Integer pageNum;
    private Integer pageSize;
    private String name;

}

