package com.ly.chatroom.entity;

import lombok.Data;

import java.util.Map;

//从后端发给前端
@Data
public class MessageToClient {
    // 聊天内容
    private String content;
    // 服务端登录的所有用户列表
    private Map<String, String> names;

    public void setContent(String msg) {
        this.content = msg;
    }
    public void setContent(String userName,String msg) {
        this.content = userName + "说:" + msg;
    }
}
