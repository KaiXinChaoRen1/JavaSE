package com.d02_IO流.p03_BufferedxxStream字节缓冲流;

import java.io.*;

/**
 * 缓冲流结合数组，进行文件拷贝
 * 缓冲输入流数组 》》 bytes数组 》》 缓冲输出流数组
 */
public class OutputDemo12 {
    public static void main(String[] args) throws IOException {

        //创建一个字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d06_io\\a.avi"));

        //创建一个字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d06_io\\copy.avi"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bis.close();
        bos.close();
    }
}
