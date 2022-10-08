package com.d03_NIO.p03_Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //获取连接通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        //设置非阻塞
        sChannel.configureBlocking(false);

        //初始化需要用的对象，放在循环外边
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("请讲话：");              //提示信息
            String msg =sc.nextLine();                  //读取键盘的输入
            buf.put(("芜湖大司马："+msg).getBytes());    //放到缓冲区
            buf.flip();                                 //切换读写模式
            sChannel.write(buf);                        //使用通道发送
            buf.clear();                                //释放资源
        }

    }
}
