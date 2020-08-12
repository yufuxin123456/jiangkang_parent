package com.czxy.jk.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "disease_library")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Assessment {

    @Id
    private Integer aid;// int(10) unsigned NOT NULL AUTO_INCREMENT,
    private String aname;// varchar(10) NOT NULL COMMENT '评估名称',
    private String result;// varchar(30) NOT NULL COMMENT '评估结果',
    private String establishdate;// char(11) NOT NULL COMMENT '创建时间',
    private String proposal;// varchar(300) NOT NULL COMMENT '建议',
    private String state;// char(11) NOT NULL COMMENT '状态',

}
