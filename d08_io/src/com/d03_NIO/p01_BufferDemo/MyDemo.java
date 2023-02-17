package com.d03_NIO.p01_BufferDemo;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class MyDemo {

    @Test       //Buffer接口的常用API
    public void Test01(){
        //分配一个缓冲区，容量设为10
        ByteBuffer myByteBuffer = ByteBuffer.allocate(10);
        System.out.println(myByteBuffer.position());  //当前位置
        System.out.println(myByteBuffer.limit());     //界限
        System.out.println(myByteBuffer.capacity());  //容量
        System.out.println("----------------------");

        String myname="BaBalwq";
        myByteBuffer.put(myname.getBytes());          //put
        System.out.println(myByteBuffer.position());
        System.out.println(myByteBuffer.limit());
        System.out.println(myByteBuffer.capacity());
        System.out.println("---------------------");

        //切换为可读模式，
        myByteBuffer.flip();
        System.out.println(myByteBuffer.position());
        System.out.println(myByteBuffer.limit());
        System.out.println(myByteBuffer.capacity());
        System.out.println("---------------------");

        char c = (char)myByteBuffer.get();            //get
        System.out.println(c);
        char c2 = (char)myByteBuffer.get();           //get
        System.out.println(c2);
        System.out.println(myByteBuffer.position());
        System.out.println(myByteBuffer.limit());
        System.out.println(myByteBuffer.capacity());
        System.out.println("---------------------");

        myByteBuffer.clear();       //当前位置设为0但不清除之前的数据，再次写入会覆盖
        System.out.println(myByteBuffer.position());
        System.out.println(myByteBuffer.limit());
        System.out.println(myByteBuffer.capacity());
        char c3 = (char)myByteBuffer.get();            //get
        System.out.println(c3);
        System.out.println("----------------------");

        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(1024);   //创建直接内存缓冲区（发送效率高，但是申请所耗费资源多，适合大量数据传输，且生命周期很长的情况）
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer1.isDirect());     //判断是否是直接内存缓冲区
        System.out.println(byteBuffer2.isDirect());


    }



}
