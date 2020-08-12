package com.czxy.jk.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "motion_library")
public class MotionLibrary {

    @Id
    private Integer mid;// int(10) unsigned NOT NULL AUTO_INCREMENT,
    private String code;// varchar(100) NOT NULL COMMENT '编码',
    private String project;// varchar(30) NOT NULL COMMENT '项目名称',
    private String intensity;// char(11) NOT NULL COMMENT '运动强度',
    private String thousand;// char(11) NOT NULL COMMENT '千步当量',
    private String exercisedate;// char(11) NOT NULL COMMENT '运动时间',
    private String agerange;// char(11) NOT NULL COMMENT '年龄区间',
    private String exercisemethod;// char(11) NOT NULL COMMENT '运动方法',
    private String attention;// varchar(300) NOT NULL COMMENT '注意事项',

}
