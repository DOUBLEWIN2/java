package com.ly.server.multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class clientConnect implements Runnable{
    Map<String,Socket> serverMap=new ConcurrentHashMap<>();
    private Socket client;

    public clientConnect(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        try {
            while(true){
                Scanner scanner=new Scanner(client.getInputStream());
                String strClientReceive="";
                if (scanner.hasNext()){
                    strClientReceive=scanner.nextLine();
                    //消除windows下用户自带的\r
                    Pattern pattern=Pattern.compile("\\r");
                    //matcher是Patter里的方法，返回值是matcher
                    Matcher matcher=pattern.matcher(strClientReceive);
                    strClientReceive=matcher.replaceAll("");
                }
                //注册流程
                if (strClientReceive.startsWith("userName")){
                    String userName = strClientReceive.split("\\:")[1];
                    userRegister(userName,client);

                }
                //群聊流程
                //G:hello world
                if (strClientReceive.startsWith("G:")){
                    String groupMsg = strClientReceive.split("\\:")[1];
                    groupChat(groupMsg);

                }
                //私聊流程
                //P:1-hello world
                if (strClientReceive.startsWith("P:")){
                    String userName = strClientReceive.split("\\:")[1].split("-")[0];
                    String privateMsg = strClientReceive.split("\\:")[1].split("-")[1];
                    privateChat(userName,privateMsg);

                }
                //用户退出
                if (strClientReceive.contains("ByeBye")){
                    String userName = strClientReceive.split(":")[0];
                    userOffline(userName);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 注册方法
     * @param userName 要注册的用户名
     * @param socket 用户名对应的Socket
     */
    private void userRegister(String userName,Socket socket){
        serverMap.put(userName,socket);
        System.out.println("用户"+userName+"上线");
        System.out.println("当前聊天室人数"+serverMap.size());
        try {
            PrintStream out = new PrintStream(socket.getOutputStream(),true,"UTF-8");
            out.println("注册成功");
            out.println("当前聊天室人数"+serverMap.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群聊方法
     * 遍历Map，向每个客户输出一遍
     * @param groupMsg
     */
    private void groupChat(String groupMsg){
        Set<Map.Entry<String,Socket>> clientEntry = serverMap.entrySet();
        Iterator<Map.Entry<String,Socket>> iterator = clientEntry.iterator();
        while (iterator.hasNext()){
            //取出每一个客户端实体
            Map.Entry<String,Socket> client = iterator.next();
            //拿到客户端输出流输出群聊信息
            PrintStream out = null;
            try {
                out = new PrintStream(client.getValue().getOutputStream(),true,"UTF-8");
                out.println("群聊信息为："+groupMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 私聊流程
     * @param userName 用户名
     * @param privateMsg 私聊信息
     */
    private  void privateChat(String userName,String privateMsg){
        //取出userName对应的Socket
        Socket client = serverMap.get(userName);
        try {
            PrintStream out = new PrintStream
                    (client.getOutputStream(),true,"UTF-8");
            out.println("私聊信息为："+privateMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户退出
     * @param userName
     */
    private void userOffline(String userName){
        //删除Map中的用户实体
        serverMap.remove(userName);
        System.out.println("用户"+userName+"已下线");
        System.out.println("当前聊天室人数为"+serverMap.size());
    }
}
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        
        //将多个客户端保存在ConcurrentHashMap中（线程安全）,
        //使用ConcurrentHashMap为了防止用户名重名的问题
        Map<String,Socket> serverMap=new ConcurrentHashMap<>();
        //根据指定端口号在本地创建服务器
        ServerSocket serverSocket=new ServerSocket(8877);
        ExecutorService executorService=
                Executors.newFixedThreadPool(20);
        for (int i=0;i<20;i++){
            Socket socket=serverSocket.accept();
            System.out.println("与客户端建立连接。。");
            executorService.submit(new clientConnect(socket));
            System.out.println("连接成功。。。");
        }
        executorService.shutdown();
        serverSocket.close();
    }
}
