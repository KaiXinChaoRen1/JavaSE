package com.d03_NIO.p02_ChannelDemo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * //Channel
 *      1必须与buffer交互。
 *      2流是单向的，通道是双向的。
 *      3通道可以异步。
 */
public class MyDemo {
    @Test
    public  void Test01() throws IOException {
        FileOutputStream fos = new FileOutputStream("b.txt");   //获取字节输出流
        FileChannel myChannel = fos.getChannel();                      //得到输出流的通道
        ByteBuffer buffer = ByteBuffer.allocate(1024);                 //获取缓冲区
        buffer.put("狂雷金刚拳".getBytes());                            //写入数据近缓冲区
        buffer.flip();                                                 //切换为写出模式
        myChannel.write(buffer);        //write指，将参数buffer中数据写出到输出流指定文件
        myChannel.close();
        System.out.println("写出文件成功");

    }

    @Test
    public void Test02() throws Exception {
        FileInputStream fis = new FileInputStream("b.txt");      //输入流
        FileChannel myChannel = fis.getChannel();                       //输入流通道
        ByteBuffer myBuffer = ByteBuffer.allocate(1024);                //获取缓冲区
        myChannel.read(myBuffer);          //read指，读入数据到buffer。
        myBuffer.flip();
        String str = new String(myBuffer.array(),0,myBuffer.remaining());
        System.out.println(str);



    }

    @Test   //通过缓冲区复制
    public  void Test03() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\iioo\\图标图片.ico");
        FileOutputStream fos = new FileOutputStream("D:\\iioo\\图标图片副本2.ico");

        FileChannel ischannel = fis.getChannel();
        FileChannel oschannel = fos.getChannel();

        ByteBuffer myBuffer = ByteBuffer.allocate(1024);

        while (true){
            myBuffer.clear();
            int flag = ischannel.read(myBuffer);    //输入流管道读取数据到buffer
            if(flag ==-1){
                break;
            }
            myBuffer.flip();                        //切换读写
            oschannel.write(myBuffer);              //输出流把buffer中数据写出文件
        }
        ischannel.close();
        oschannel.close();
        System.out.println("复制成功");



  }

    @Test   //通道直接复制
    public  void  Test04() throws Exception {
        FileInputStream fis = new FileInputStream("D:\\iioo\\图标图片.ico");
        FileOutputStream fos = new FileOutputStream("D:\\iioo\\图标图片副本2w.ico");

        FileChannel ischannel = fis.getChannel();
        FileChannel oschannel = fos.getChannel();

        //两种方式
        //oschannel.transferFrom(ischannel,ischannel.position(),ischannel.size());
        ischannel.transferTo(oschannel.position(),oschannel.size(),oschannel);

        ischannel.close();
        oschannel.close();
        System.out.println("复制成功");

    }

}
