package com.d02_io.p02_FileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 利用输入输出流，实现文件复制
 */
public class OutputDemo9 {
    public static void main(String[] args) throws IOException {

        //创建了字节输入流,准备读数据.
        FileInputStream fis = new FileInputStream("d:\\桌面\\a.avi");
        //创建了字节输出流,准备写数据.
        FileOutputStream fos = new FileOutputStream("d06_io\\heihei.avi");

        int b;
        while((b = fis.read())!=-1){    //读一个
            fos.write(b);               //写一个（这样有点慢）
        }

        fis.close();
        fos.close();
    }
}
