package com.d01_file;

import java.io.File;
import java.io.IOException;

/**
 * File类创建文件或者文件夹的方法
 */
public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        //creatNewFile方法 没文件就创建 有文件就算了
        File f1 = new File("d:\\iioo\\java.txt");
        System.out.println(f1.createNewFile());

        //创建多级（单级）目录
        File f3 = new File("d:\\iioo\\赛尔号\\精灵太空站\\精灵大乱斗");
        System.out.println(f3.mkdirs());


    }
}
