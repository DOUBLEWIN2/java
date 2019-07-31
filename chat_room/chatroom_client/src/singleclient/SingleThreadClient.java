package singleclient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //与服务器端建立连接
        Socket socket=new Socket("127.0.0.1",8866);
        PrintStream printClient=new PrintStream(socket.getOutputStream());
        printClient.println("服务器你好。。。");
        Scanner server=new Scanner(socket.getInputStream());
        if(server.hasNext()){
            System.out.println("服务器端输入内容： "+server.nextLine());
        }
        server.close();
        printClient.close();
        socket.close();

    }
}
