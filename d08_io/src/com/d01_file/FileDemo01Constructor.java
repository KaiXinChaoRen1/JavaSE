package com.d01_file;

import java.io.File;

/**
 * File类可以操作系统中的 '文件'or'文件夹'
 *
 * File 类三种构造方法
 */
public class FileDemo01Constructor {
    public static void main(String[] args) {

        File f1 = new File("C:\\Users\\lwq\\Desktop\\io.txt");
        System.out.println(f1);


        File f2 = new File("C:\\Users\\lwq\\Desktop", "io.txt");
        System.out.println(f2);


        File f3 = new File("C:\\Users\\lwq\\Desktop");
        File f4 = new File(f3, "io.txt");
        System.out.println(f4);
    }
}
