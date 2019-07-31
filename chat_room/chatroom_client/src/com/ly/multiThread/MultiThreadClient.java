package com.ly.multiThread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//从服务端读取内容
class ReadFromServer implements Runnable{
    private Socket client;
    public ReadFromServer(Socket client) {
        this.client=client;
    }
    @Override
    public void run() {
        try {
            Scanner scanner =new Scanner(client.getInputStream());
            while (true){
                //判断客户端是否关闭，若关闭直接退出循环
                if (client.isClosed()){
                    System.out.println("客户端已经关闭");
                    scanner.close();
                    break;
                }
                if (scanner.hasNext()){
                    String strReadServer=scanner.nextLine();
                    System.out.println("服务器发送的消息： "+strReadServer);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//给服务器端发送内容
class SendMsgToServer implements Runnable{
    private Socket client;
    public SendMsgToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //获取输出流，向服务器发送消息
            PrintStream printStream=new PrintStream(client.getOutputStream());
            Scanner scanner=new Scanner(System.in);
            while(true){
                String strReadClient="";
                String string="ByeBye";
                if (scanner.hasNext()) {
                    strReadClient = scanner.nextLine();
                    System.out.println("客户端输入： " + strReadClient);
                }
                //向服务器发送信息
                printStream.println(strReadClient);
                if (strReadClient.contains(string)){
                    System.out.println("客户端已下线。。");
                    scanner.close();
                    printStream.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadClient {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("127.0.0.1",8877);
        Thread readThread = new Thread(new ReadFromServer(client));
        Thread sendThread = new Thread(new SendMsgToServer(client));
        readThread.start();
        sendThread.start();
    }
}
