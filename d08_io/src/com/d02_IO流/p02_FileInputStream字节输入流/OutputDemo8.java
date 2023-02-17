package com.d02_IO流.p02_FileInputStream字节输入流;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取多个字节
 */
public class OutputDemo8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:\\iioo\\a.txt");

        int b;
        while ((b = fis.read()) != -1) {   //文件读完了，再读就会返回-1
            System.out.println((char) b);
        }
        fis.close();
    }
}
