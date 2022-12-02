package com.d02_IO流.p01_FileOutputStream字节输出流;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读写（I/O）是以内存为主语，内存读or内存写
 *
 * byte 是字节数据类型 ，是有符号型的，占1 个字节；大小范围为-128—127
 */
public class OutputDemo1 {
    public static void main(String[] args) throws IOException {

        //1.创建字节输出流的对象 （构造方法参数可以是 字符串 或者 File对象 等）
        // --- 告诉虚拟机我要往哪个文件中写数据了
                //如果文件不存在,会帮我们自动创建（但要保证其父目录存在）.
                //如果文件存在,会把文件清空.
        FileOutputStream fos = new FileOutputStream("C:\\Users\\lwq\\Desktop\\io.txt");

        //2,写数据(传递一个整数,那么实际上写到文件中的,是这个整数在码表中对应的那个字符.)
        fos.write(97);
        fos.write(98);
        fos.write('c');
        fos.write('&');
        //传入字符串报错
        //fos.write("h");

        //3,释放资源(对文件的操作结束)
        fos.close();


    }
}
