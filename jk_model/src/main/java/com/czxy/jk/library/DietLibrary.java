package com.czxy.jk.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 膳食表
 */

@Table(name = "diet_library")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietLibrary {

    @Id
    private Integer mid;
    private String code ;//char(20) NOT NULL COMMENT '编码',
    private String foodname ;//char(50) NOT NULL COMMENT '食品名称',
    private String type;// char(11) NOT NULL COMMENT '所属类型',
    private String energy ;//char(11) NOT NULL COMMENT '100g含能量',
    private String protein ;//char(11) NOT NULL COMMENT '蛋白质含量',
    private String fat ;//char(11) NOT NULL COMMENT '脂肪含量',
    private String proposal ;//char(11) NOT NULL COMMENT '建议人群',
    private String remarks ;//char(11) NOT NULL COMMENT '备注',


}
