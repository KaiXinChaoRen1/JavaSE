package com.d02_io.p02_FileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制2.0
 */
public class OutputDemo10 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("d:\\桌面\\a.avi");
        FileOutputStream fos = new FileOutputStream("d06_io\\a副本.avi");

        byte[] bytes = new byte[1024];
        int len;            //表示本次读到的有效字节的个数

        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        fis.close();
        fos.close();
    }
}