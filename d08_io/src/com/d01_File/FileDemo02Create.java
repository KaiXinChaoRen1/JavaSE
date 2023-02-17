package com.d01_File;

import java.io.File;
import java.io.IOException;

/**
 * File类 创建 文件 or 文件夹
 */
public class FileDemo02Create {
    public static void main(String[] args) throws IOException {
        //creatNewFile方法 没文件就创建 有文件就算了
        File f1 = new File("C:\\Users\\lwq\\Desktop\\io.txt");
        System.out.println(f1.createNewFile());

        //创建多级（单级）目录
        File f3 = new File("C:\\Users\\lwq\\Desktop\\io\\io2");
        System.out.println(f3.mkdirs());


    }
}
