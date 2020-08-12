package com.czxy.jk.service;

import com.czxy.jk.dao.LoginMapper;
import com.czxy.jk.login.Login;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private LoginMapper loginMapper;

    public Login login(Login login) {
        Login l = loginMapper.login(login);
        return l;
    }
}
