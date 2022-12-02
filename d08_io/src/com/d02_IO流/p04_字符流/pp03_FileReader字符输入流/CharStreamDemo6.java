package com.d02_IO流.p04_字符流.pp03_FileReader字符输入流;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流FileReader
 */
public class CharStreamDemo6 {
    public static void main(String[] args) throws IOException {
        //创建字符输入流的对象
        FileReader fr = new FileReader("C:\\Users\\lwq\\Desktop\\io.txt");


        //读取数据（一次读取一个字符）
        int ch;
        while((ch = fr.read()) != -1){
            System.out.println((char) ch);
        }

        //释放资源
        fr.close();
    }
}
