package com.ly.chatroom.utils;

import com.ly.chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "datasource.properties";
        Properties properties = CommUtils.loadProperties(fileName);
        System.out.println(properties);
        String url = properties.getProperty("url");
        Assert.assertEquals(null,url);
    }

    @Test
    public void gsonTest1() {
        User user = new User();
        user.setId(10);
        user.setUserName("test");
        user.setPassword("123");
        String jsonStr = CommUtils.objectToJson(user);
        System.out.println(jsonStr);
    }

    @Test
    public void gsonTest2() {
        String jsonStr = "{\"id\":10,\"userName\":\"test\",\"password\":\"123\"}";
        User user = (User) CommUtils.jsonToObject(jsonStr,User.class);
        System.out.println(user);
    }
}