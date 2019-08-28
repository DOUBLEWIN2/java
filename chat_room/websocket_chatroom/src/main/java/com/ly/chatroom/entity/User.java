package com.ly.chatroom.entity;

import lombok.Data;
//对应数据库中的字段
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
}
