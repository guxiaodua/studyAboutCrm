package com.study.crm.settings.service;

import com.study.crm.exception.LoginException;
import com.study.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
