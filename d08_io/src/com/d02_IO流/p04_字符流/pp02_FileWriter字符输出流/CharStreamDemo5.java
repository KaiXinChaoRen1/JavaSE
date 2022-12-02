package com.d02_IO流.p04_字符流.pp02_FileWriter字符输出流;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字节流是直接与数据产生交互，而字符流在与数据交互之前要经过一个缓冲区 。
 * 使用字符流对资源进行操作的时候，如果不使用close()方法，则数据将保存在缓冲区中而没有真正的写入
 *  close() 关闭流的同时将清空缓冲区中的数据
 *  flush() 清空缓冲区中的数据
 */
public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("C:\\Users\\lwq\\Desktop\\io.txt");

        fw.write("黑马程序员");
        fw.flush();

        fw.write("666");    //刷新流之后还可以再写
        fw.flush();

        fw.close();
        //fw.write("aaa");    //报错，关闭流之后不能再写(废话)
    }
}
