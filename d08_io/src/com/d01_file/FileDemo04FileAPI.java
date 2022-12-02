package com.d01_file;

import java.io.File;

public class FileDemo04FileAPI {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\lwq\\Desktop\\io");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println(f1.exists());
        System.out.println(f1.getAbsolutePath());//得到绝对路径
        System.out.println(f1.getPath());//抽象路径
        System.out.println(f1.getName());

        System.out.println("--------------------------------------------");

        File f2 = new File("C:\\Users\\lwq\\Desktop\\io");
        String[] sarr = f2.list();  //返回该目录下所有文件和目录名称
        for (String s1 : sarr) {
            System.out.println(s1);
        }

        System.out.println("----------------------------------------------");

        File[] farr = f2.listFiles();//文件数组
        for (File f : farr) {
            if (f.isFile()) {       //如果是文件就输出其名称
                System.out.println(f.getName());
            }
        }

    }
}
