package com.czxy.jk.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
   private String profileid ;//varchar(100) NOT NULL COMMENT '档案id',
   private String phone;// varchar(100) NOT NULL COMMENT '手机号',
   private String sex ;//char(2) DEFAULT NULL COMMENT '性别',
   private Integer age;//int 年龄
    @Column(name = "register_date")
   private String registerDate ;// timeDEFAULT NULL COMMENT '注册时间',

}
