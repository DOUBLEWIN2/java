package com.ly.chatroom.dao;

import com.ly.chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;



public class AccountDaoTest {
    private AccountDao accountDao = new AccountDao();
    @Test
    public void userLogin() {
        User user = accountDao.userLogin("test","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void userRegister() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("123");
        boolean isSuccess = accountDao.userRegister(user);
        Assert.assertEquals(true,isSuccess);
    }
}