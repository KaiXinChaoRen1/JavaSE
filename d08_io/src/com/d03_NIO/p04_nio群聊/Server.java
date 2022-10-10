package com.d03_NIO.p04_nio群聊;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {

    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT = 9999;

    //构造方法（包含初始化逻辑）
    public Server() {
        try {
            selector = Selector.open();                          //获取选择器
            ssChannel = ServerSocketChannel.open();              //获取通道
            ssChannel.bind(new InetSocketAddress(PORT));         //通道绑定端口
            ssChannel.configureBlocking(false);                  //通道设非阻塞
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);//通道注册到选择器，监听接入事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (selector.select() > 0) { //如果选择器有事件
                //7.获取选择器注册通道中已经就绪的事件
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                //8.遍历事件
                while (it.hasNext()) {
                    //9.拿到事件
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {  //如果是接入事件
                        //通过服务端通道获取其客户端端通道
                        SocketChannel schannel = ssChannel.accept();
                        //设置为非阻塞
                        schannel.configureBlocking(false);
                        //客户端通道注册到选择器，监听读事件
                        schannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {   //如果是读事件
                        readClientDate(sk);         //把事件给读取方法
                    }
                    //处理结束，移除事件
                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readClientDate(SelectionKey sk) {
        SocketChannel sChannel = null;
        try {
            //获取当前客户端通道
            sChannel = (SocketChannel) sk.channel();
            //创建缓冲区对象接受数据
            ByteBuffer myByteBuffer = ByteBuffer.allocate(1024);
            int len = sChannel.read(myByteBuffer);
            if (len > 0) {
                myByteBuffer.flip();
                String msg = new String(myByteBuffer.array(), 0, myByteBuffer.remaining());
                //打印日志
                System.out.println("接收到客户端消息" + msg);
                //把消息发给所有人
                sendMsgToAll(msg, sChannel);
            }
        } catch (Exception e) {
            try {
                System.out.println(sChannel.getRemoteAddress() + ":离线了");
                sk.cancel();
                sChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 把当前的客户端消息推送给所有注册的channel
     */
    private void sendMsgToAll(String msg, SocketChannel sChannel) throws IOException {
        System.out.println("服务端开始转发消息，处理的线程为：" + Thread.currentThread().getName());
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            //不要把消息发给自己
            if (channel instanceof SocketChannel && channel != sChannel) {
                ByteBuffer buf = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) channel).write(buf);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("-----服务端启动-----");
        //创建对象
        Server myServer = new Server();
        //开始监听
        myServer.listen();


    }

}
