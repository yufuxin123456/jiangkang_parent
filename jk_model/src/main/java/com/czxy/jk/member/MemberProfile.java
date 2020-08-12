package com.czxy.jk.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="member_profile")
@NoArgsConstructor
@AllArgsConstructor
public class MemberProfile {

    @Id
    private Integer mid;
    private String mpid ;//varchar(100) NOT NULL COMMENT '档案id',
    private String id ;//char(16) NOT NULL COMMENT '患者身份证',
    private String loginpassword ;//varchar(10) NOT NULL COMMENT '会员登录密码',
    private String nation ;//char(10) NOT NULL COMMENT '民族',
    private String datebirth ;//char(10) NOT NULL COMMENT '出生日期',
    private String mailbox ;//varchar(100) NOT NULL COMMENT '邮箱',
    private String marriage ;//char(2) NOT NULL COMMENT '婚姻状况',
    private String occupation ;//char(8) NOT NULL COMMENT '职业',
    private String culture ;//char(2) NOT NULL COMMENT '文化程度',
    private String remarks ;//char(2) NOT NULL COMMENT '备注',
    private Integer height ;//int(2) NOT NULL COMMENT '身高',
    private Integer weight ;//int(8) NOT NULL COMMENT '体重',
    private Integer diastolic;// int(8) NOT NULL COMMENT '舒张压',
    private Integer systolic ;//int(8) NOT NULL COMMENT '收缩压',
    private Integer breathe ;//int(8) NOT NULL COMMENT '呼吸频次',
    private Integer temperature ;//int(8) NOT NULL COMMENT '体温',
    private Integer waist ;//int(8) NOT NULL COMMENT '腰围',
    private Integer hipline ;//int(8) NOT NULL COMMENT '臀围',
    private Integer bmt ;//int(8) NOT NULL COMMENT 'BMI',
    private Integer oximetry ;//int(8) NOT NULL COMMENT '血氧饱和度',
    private String past ;//varchar(500) NOT NULL COMMENT '过去的病的历史',
    private String familyhistory ;//varchar(500) NOT NULL COMMENT '家族史',
    private String allergy ;//varchar(500) NOT NULL COMMENT '过敏史',
    private String medical ;//varchar(500) NOT NULL COMMENT '病史',
    private String slow ;//varchar(500) NOT NULL COMMENT '慢性病',
    private String hm ;//char(50) DEFAULT NULL COMMENT '健康管理师',

}
