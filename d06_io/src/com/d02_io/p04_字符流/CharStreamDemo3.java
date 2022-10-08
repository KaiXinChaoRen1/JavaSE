package com.d02_io.p04_字符流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流FileWriter
 */
public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //一，创建字符输出流的对象，
        FileWriter fw = new FileWriter("d06_io\\a.txt");


        //二，写出数据（五种方式）
        //void write​(int c)            1.写一个字符
        fw.write(97);
        fw.write(98);
        fw.write(99);

        //void write​(char[] cbuf)      2.写出一个字符数组
        char [] chars = {97,98,99,100,101};
        fw.write(chars);

        //void write​(char[] cbuf, int off, int len)    3.写出字符数组的一部分
        char [] chars2 = {97,98,99,100,101};
        fw.write(chars,0,3);

        //void write​(String str)       4.写一个字符串
        String line = "黑马程序员abc";
        fw.write(line);

        //void write​(String str, int off, int len)      5.写一个字符串的一部分
        String line2 = "黑马程序员abc";
        fw.write(line,0,2);


        //三，释放资源
        fw.close();


    }
}
