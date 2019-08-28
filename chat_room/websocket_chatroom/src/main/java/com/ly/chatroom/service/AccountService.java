package com.ly.chatroom.service;


import com.ly.chatroom.dao.AccountDao;
import com.ly.chatroom.entity.User;

/**
 * 业务层，具体处理数据库业务，调用dao层
 */
public class AccountService {
    private AccountDao accountDao = new AccountDao();

    // 用户登陆
    public boolean userLogin(String userName,String password) {
        User user = accountDao.userLogin(userName,password);
        if (user == null) {
            return false;
        }
        return true;
    }

    // 用户注册
    public boolean userRegister(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return accountDao.userRegister(user);
    }
}
