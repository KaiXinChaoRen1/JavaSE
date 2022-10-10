package com.d02_io.p03_BufferedIOStream;

import java.io.*;

/**
 * 字节缓冲流(构造方法需要字节流，因为缓冲流仅提供缓冲区，读写数据还要靠字节流对象)
 */
public class OutputDemo11 {
    public static void main(String[] args) throws IOException {

        //创建一个字节缓冲输入流
        //在底层创建了一个默认长度为8192的字节数组。
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d06_io\\a.avi"));
        //创建一个字节缓冲输出流
        //在底层也创建了一个默认长度为8192的字节数组。
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d06_io\\a2.avi"));

        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }

        //方法的底层会把字节流给关闭。
        bis.close();
        bos.close();

    }
}
