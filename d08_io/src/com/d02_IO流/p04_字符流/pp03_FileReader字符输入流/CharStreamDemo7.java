package com.d02_IO流.p04_字符流.pp03_FileReader字符输入流;

import java.io.FileReader;
import java.io.IOException;

/**
 *  一次读取多个字符。
 */
public class CharStreamDemo7 {
    public static void main(String[] args) throws IOException {

        //创建对象
        FileReader fr = new FileReader("C:\\Users\\lwq\\Desktop\\io.txt");

        //创建一个数组
        char [] chars = new char[1024];
        int len;

        while((len = fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }

        fr.close();
    }
}
