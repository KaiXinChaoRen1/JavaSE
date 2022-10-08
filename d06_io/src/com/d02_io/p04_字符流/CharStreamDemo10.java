package com.d02_io.p04_字符流;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲输出流BufferedWriter
 */
public class CharStreamDemo10 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("d06_io\\a.txt"));

        //写出数据
        //1.单个字符
        bw.write(97);
        bw.write("\r\n");

        //2.字符数组
        char [] chars = {97,98,99,100,101};
        bw.write(chars);
        bw.write("\r\n");

        //3.字符数组的一部分
        bw.write(chars,0,3);
        bw.write("\r\n");

        //4.字符串
        bw.write("黑马程序员");
        bw.write("\r\n");

        //5.字符串的一部分
        String line = "abcdefg";
        bw.write(line,0,5);

        bw.flush();
        bw.close();

    }
}
