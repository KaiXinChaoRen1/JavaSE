package com.d01_file;

import java.io.File;

/**
 * File 类三种构造方法
 * File类可以操作系统中的文件或文件夹
 */
public class FileDemo01 {
    public static void main(String[] args) {

        File f1 = new File("D:\\itcase\\java.txt");
        System.out.println(f1);


        File f2 = new File("D:\\itcase", "java.txt");
        System.out.println(f2);


        File f3 = new File("D:\\itcase");
        File f4 = new File(f3, "java.txt");
        System.out.println(f4);
    }
}
