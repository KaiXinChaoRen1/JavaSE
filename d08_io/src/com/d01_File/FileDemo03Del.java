package com.d01_File;

import java.io.File;

/**
 * 删除方法
 * 1.不走回收站的.
 * 2.删除文件,直接删除.文件夹,必须是空文件夹
 * 3.如果要删除一个有内容的文件夹,只能先进入到这个文件夹,把里面的内容全部删除完毕,才能再次删除这个文件夹
 */
public class FileDemo03Del {

    public static void main(String[] args) {
        //method1();

        File file = new File("C:\\itheima");
        boolean result = file.delete();
        System.out.println(result);
    }


    private static void method1() {
        File file = new File("C:\\itheima\\a.txt");
        boolean result = file.delete();
        System.out.println(result);
    }
}
