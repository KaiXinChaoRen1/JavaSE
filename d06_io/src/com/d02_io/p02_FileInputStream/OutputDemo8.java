package com.d02_io.p02_FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取多个字节
 */
public class OutputDemo8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("d:\\iioo\\a.txt");

        int b;
        while ((b = fis.read())!=-1){   //文件读完了，再读就会返回-1
            System.out.println((char) b);
        }
        fis.close();
    }
}
