package com.czxy.jk.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name="member_profile")
@NoArgsConstructor
@AllArgsConstructor
public class MemberProfile {

    @Id
    private String mpid;// VARCHAR(100) NOT NULL COMMENT '档案号',
    private String id;// CHAR(18) NOT NULL COMMENT '患者身份证',
    private String phone;// CHAR(11) COMMENT '手机号',
    private String username;// CHAR(11) COMMENT '姓名',
    private String sex;// CHAR(11) COMMENT '性别',
    private String age;// CHAR(11) COMMENT '年龄',
    private String password;// VARCHAR(10) NOT NULL COMMENT '会员登录密码',
    private String nation;// CHAR(10) NOT NULL COMMENT '民族',
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datebirth;// CHAR(10)  COMMENT '出生日期',
    private String mailbox;// VARCHAR(100)  COMMENT '邮箱',
    private String marriage;// CHAR(20)  COMMENT '婚姻状况',
    private String occupation;// CHAR(8)  COMMENT '职业',
    private String culture;// CHAR(20)  COMMENT '文化程度',
    private String hm;// CHAR(50) COMMENT '健康管理师',
    private String native_place;// VARCHAR(100)   COMMENT '籍贯',#
    private Boolean archives;// CHAR(2)   COMMENT '档案状态',#
    private String remarks;// TEXT  COMMENT '备注',#

    private String height;// INT(20)   COMMENT '身高',
    private String weight;// INT(80)   COMMENT '体重',
    private String diastolic;// INT(80)   COMMENT '舒张压',
    private String systolic;// INT(80)   COMMENT '收缩压',

    private String breathe;// INT(80)   COMMENT '呼吸频次',
    private String temperature;// INT(80)   COMMENT '体温',
    private String waist;// INT(80)   COMMENT '腰围',
    private String hipline ;//INT(80)   COMMENT '臀围',
    private String bmt ;//INT(80)   COMMENT 'BMI',
    private String oximetry ;//INT(80)   COMMENT '血氧饱和度',

    private String past ;//TEXT   COMMENT '过去的病的历史',
    private String familyhistory ;//TEXT   COMMENT '家族史',
    private String allergy ;//TEXT   COMMENT '过敏史',
    private String medical ;//TEXT COMMENT '病史',
    private String slow ;//TEXT   COMMENT '慢性病',

}
