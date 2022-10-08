package com.d03_NIO.p03_Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * NIO非阻塞通信 服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("----服务端启动----");
        //1.获取服务端通道
        ServerSocketChannel ssChannel=ServerSocketChannel.open();
        //2.切换为非阻塞
        ssChannel.configureBlocking(false);
        //3.通道绑定端口
        ssChannel.bind(new InetSocketAddress(9999));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上，并监听接受事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.selector轮询事件
        while (selector.select()>0){
            //7.获取选择器注册通道中已经就绪的事件
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            //8.遍历事件
            while (it.hasNext()){
                System.out.println("进入循环");         //提示信息
                //9.拿到事件
                SelectionKey sk = it.next();
                if(sk.isAcceptable()){  //如果是接入事件
                    //通过服务器通道，获取当前接入的客户端通道
                    SocketChannel schannel = ssChannel.accept();
                    //设置为非阻塞
                    schannel.configureBlocking(false);
                    //当前客户端通道注册到选择器，监听读事件
                    schannel.register(selector,SelectionKey.OP_READ);
                }
                else if(sk.isReadable()){   //如果是读事件
                    //获取事件对应的客户端通道
                    SocketChannel schannel =(SocketChannel)sk.channel();
                    ByteBuffer myByteBuffer=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=schannel.read(myByteBuffer))>0){
                        myByteBuffer.flip();
                        System.out.println(new String(myByteBuffer.array(),0,len));
                        myByteBuffer.clear();
                    }
                }
                //处理结束，移除事件
                it.remove();

            }
        }
    }



}
