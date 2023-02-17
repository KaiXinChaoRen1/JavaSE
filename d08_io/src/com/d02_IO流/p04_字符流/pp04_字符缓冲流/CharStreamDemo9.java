package com.d02_IO流.p04_字符流.pp04_字符缓冲流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流BufferedReader
 */
public class CharStreamDemo9 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输入流(注意构造)
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lwq\\Desktop\\io.txt"));

        //读取数据
        char [] chars = new char[1024];
        int len;
        while((len = br.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }

        br.close();
    }
}
