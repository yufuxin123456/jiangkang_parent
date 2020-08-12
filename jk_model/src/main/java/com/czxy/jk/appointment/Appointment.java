package com.czxy.jk.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment")
public class Appointment {

    @Id
    private String  aid ;//varchar(100) NOT NULL COMMENT '档案id',
    private String  adate;// time DEFAULT NULL COMMENT '预约时间',
    private String  atype;// char(10) DEFAULT NULL COMMENT '预约类型',
    private String  astatus;// char(2) DEFAULT NULL COMMENT '预约状态',


}
