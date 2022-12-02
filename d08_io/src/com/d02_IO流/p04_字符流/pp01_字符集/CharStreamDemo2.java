package com.d02_IO流.p04_字符流.pp01_字符集;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 字符集
 * 字符编码解码
 * UTF-8  一个中文三个字节
 * GBK    一个中文两个字节
 */
public class  CharStreamDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "黑马程序员";

        byte[] bytes1 = str.getBytes();                    //使用idea默认的字符集(UTF-8)将中文编码为一系列的字节，将结果存储到新的字节数组中
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str.getBytes("UTF-8");//使用指定的字符集
        System.out.println(Arrays.toString(bytes2));

        byte[] bytes3 = str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes3));

        System.out.println("--------------------------------------------------------");


        byte [] bytes4 = {-23, -69, -111, -23, -87, -84, -25, -88, -117, -27, -70, -113, -27, -111, -104};

        byte [] bytes5 = {-70, -38, -62, -19, -77, -52, -48, -14, -44, -79};

        //利用默认的UTF-8进行解码
        String s1 = new String(bytes4);     //使用平台的默认字符集解码
        System.out.println(s1);

        //利用指定的GB2312进行解码
        String s2 = new String(bytes5,"GB2312");//使用指定的字符集解码
        System.out.println(s2);

        //利用指定的GB2312进行解码
        String s3 = new String(bytes5,"GBK");//使用指定的字符集解码
        System.out.println(s2);

    }
}
