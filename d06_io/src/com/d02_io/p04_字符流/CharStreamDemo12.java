package com.d02_io.p04_字符流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * readLine 读一整行
 */
public class CharStreamDemo12 {
    public static void main(String[] args) throws IOException {

        //创建对象
        BufferedReader br = new BufferedReader(new FileReader("d06_io\\a.txt"));


        //读取数据
//        String line1 = br.readLine();
//        String line2 = br.readLine();
//        String line3 = br.readLine();
//        String line4 = br.readLine();//在之前，如果读不到数据，返回-1.但是readLine如果读不到数据返回null
//        String line5 = br.readLine();
//
//        System.out.println(line1);
//        System.out.println(line2);
//        System.out.println(line3);
//        System.out.println(line4);
//        System.out.println(line5);

        //循环读取
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        // 释放资源
        br.close();
    }
}
