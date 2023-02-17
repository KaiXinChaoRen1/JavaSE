package com.d02_IO流.p04_字符流.pp04_字符缓冲流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * newLine  跨平台的换行符
 */
public class CharStreamDemo11 {
    public static void main(String[] args) throws IOException {

        //创建对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\lwq\\Desktop\\io.txt"));

        //写出数据
        bw.write("黑马程序员666");
        bw.newLine();//跨平台的回车换行
        bw.write("abcdef");
        bw.newLine();//跨平台的回车换行
        bw.write("-------------");

        //刷新流
        bw.flush();
        //释放资源
        bw.close();
    }
}
