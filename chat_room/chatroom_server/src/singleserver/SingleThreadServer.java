package singleserver;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端
        ServerSocket serverSocket=new ServerSocket(8866);
        //与客户端建立连接
        System.out.println("等待客户端连接。。。");
        Socket socket=serverSocket.accept();
        Scanner client=new Scanner(socket.getInputStream());
        if(client.hasNext()){
            System.out.println("客户端输入的内容： "+client.nextLine());
        }
        PrintStream printServer=
                new PrintStream(socket.getOutputStream());
        printServer.println("客户端你好。。。。");
        client.close();
        printServer.close();
        serverSocket.close();
    }
}
