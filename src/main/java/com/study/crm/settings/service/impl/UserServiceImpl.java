package com.study.crm.settings.service.impl;

import com.study.crm.exception.LoginException;
import com.study.crm.settings.dao.UserDao;
import com.study.crm.settings.domain.User;
import com.study.crm.settings.service.UserService;
import com.study.crm.utils.DateTimeUtil;
import com.study.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    public User login(String loginAct, String loginPwd, String ip) throws LoginException {

        Map<String,String> map = new HashMap<String, String>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);

        //System.out.println("呵呵,这是个断点!");

        User user = userDao.login(map);
        /*---------*/
        /*String s = user.toString();
        System.out.println(s);*/
        /*---------*/
        /*
            User{id='40f6cdea0bd34aceb77492a1656d9fb3',
            loginAct='zs',
            name='张三',
            loginPwd='202cb962ac59075b964b07152d234b70',
            email='zs@qq.com',
            expireTime='2021-11-30 23:50:55',
            lockState='1',
            deptno='A001',
            allowTps='null',    //allowTps-->allowIps
            createTime='2018-11-22 11:37:34',
            createBy='张三',
            editTime='null',
            editBy='null'}
        */


        if (user==null){
            throw new LoginException("账号密码错误");
        }
        //如果程序能够成功的执行到该行,说明账号密码正确
        //需要继续向下验证其他3项信息

        //验证失效时间
        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if (expireTime.compareTo(currentTime)<0){
            throw new LoginException("账号已失效");
        }

        //判断锁定状态
        String lockState = user.getLockState();
        if ("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }

        //判断ip地址
        String allowIps = user.getAllowIps();
        if (!allowIps.contains(ip)){
            throw new LoginException("ip地址受限");
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> uList = userDao.getUserList();
        return uList;
    }
}
