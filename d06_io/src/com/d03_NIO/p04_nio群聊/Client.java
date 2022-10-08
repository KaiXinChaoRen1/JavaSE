package com.d03_NIO.p04_nio群聊;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

    private Selector selector;
    private SocketChannel socketChannel;
    private static final int PORT = 9999;

    public Client(){
        try {
            //创建选择器
            selector = Selector.open();
            //连接客户端
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            //设置非阻塞
            socketChannel.configureBlocking(false);
            //监听群发的读时间
            socketChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("-----客户端启动完成-----");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client myClient = new Client();
        new Thread(()->{
            try {
                myClient.readInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            myClient.sendToServer(s);
        }

    }

    /**
     *发送消息的方法
     */
    private void sendToServer(String s) {
        try {
            socketChannel.write(ByteBuffer.wrap(("猛虎王说："+s).getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  接受消息的方法
     */
    private void readInfo() throws IOException {
        while(selector.select()>0){
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            //8.遍历事件
            while (it.hasNext()){
                SelectionKey sk = it.next();
                if(sk.isReadable()) {   //如果是读事件
                    SocketChannel schannel = (SocketChannel) sk.channel();
                    ByteBuffer myByteBuffer = ByteBuffer.allocate(1024);
                    schannel.read(myByteBuffer);
                    System.out.println(new String(myByteBuffer.array()).trim());
                }
                it.remove();
            }
        }
    }


}
