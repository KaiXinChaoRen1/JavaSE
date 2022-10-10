package com.d02_io.p04_字符流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流BufferedReader
 */
public class CharStreamDemo9 {
    public static void main(String[] args) throws IOException {
        //字符缓冲输入流(注意构造)
        BufferedReader br = new BufferedReader(new FileReader("d06_io\\a.txt"));

        //读取数据
        char [] chars = new char[1024];
        int len;
        while((len = br.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }

        br.close();
    }
}
