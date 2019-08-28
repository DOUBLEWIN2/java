package com.ly.chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 封装基础的工具方法，如加载配置文件、json序列化等
 */
public class CommUtils {
    private static final Gson gson=new GsonBuilder().create();
    private CommUtils(){}

    /**
     * 根据指定的文件名加载配置文件
     * @param filename  配置文件名
     * @return
     */
    public static Properties loadProperties(String filename){
        Properties properties=new Properties();
        // getResourceAsStream会获取到类加载器下的所有文件
        //获取到当前配置文件夹下的文件输入流
        InputStream inputStream=CommUtils.class.getClassLoader().
                getResourceAsStream(filename);
        //加载配置文件中所有的内容，使用load方法
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String objectToJson(Object obj) {
        return gson.toJson(obj);
    }

    public static Object jsonToObject(String jsonStr,Class objClass) {
        return gson.fromJson(jsonStr,objClass);
    }

    public static boolean strIsNull(String str) {
        return str == null || str.equals("");
    }
}
