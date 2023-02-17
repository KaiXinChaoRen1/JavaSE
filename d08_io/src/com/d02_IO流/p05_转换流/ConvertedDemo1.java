package com.d02_IO流.p05_转换流;


import java.io.*;

/**
 * 文件--字节流》》转换流--**内存**--转换流》》字节流--文件
 */
public class ConvertedDemo1 {
    public static void main(String[] args) throws IOException {

        //如果文件的编码和idea默认的编码不一样，则会产生乱码
        FileReader fr = new FileReader("D:\\桌面\\a.txt");
        int ch;
        while ((ch = fr.read())!=-1){
            System.out.println((char) ch);
        }
        fr.close();



        //使用转换流并指定码表去读取文件解决乱码.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\桌面\\a.txt"),"gbk");
        int ch2;
        while((ch2 = isr.read())!=-1){
            System.out.println((char) ch2);
        }
        isr.close();

        //使用转换流并指定码表向文件写入数据
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\桌面\\b.txt"),"UTF-8");
        osw.write("我爱学习,谁也别打扰我");
        osw.close();

    }
}
