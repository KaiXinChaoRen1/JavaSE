package com.d02_IO流.p01_FileOutputStream字节输出流;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 换行 and 续写（不同操作系统换行符不一样）
 */
public class OutputDemo5 {
    public static void main(String[] args) throws IOException {

        //第二个参数是续写开关,（默认为false）。设为true时，表示续写，创建对象的这行代码不会清空文件.
        FileOutputStream fos = new FileOutputStream("d06_io\\c.txt", true);

        //换行
        fos.write("\r\n".getBytes());
        fos.write(97);
        //换行
        fos.write("\r\n".getBytes());
        fos.write(98);
        //换行
        fos.write("\r\n".getBytes());
        fos.write(99);


        fos.close();
    }
}
