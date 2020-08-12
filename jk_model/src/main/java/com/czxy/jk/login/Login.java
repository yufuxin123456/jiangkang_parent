package com.czxy.jk.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "login")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    private Integer uid;// int(10) unsigned NOT NULL AUTO_INCREMENT,
    private String username;// varchar(100) NOT NULL,
    private String password;// varchar(100) NOT NULL,

    @Transient
    private String verifyCode;//验证码

}
