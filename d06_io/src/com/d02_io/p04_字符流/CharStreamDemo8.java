package com.d02_io.p04_字符流;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *  将键盘录入的用户名和密码保存到本地实现永久化存储
 *  要求：用户名独占一行，密码独占一行
 */
public class CharStreamDemo8 {
    public static void main(String[] args) throws IOException {

        //（一）键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入用户名");
        String username = sc.next();
        System.out.println("请录入密码");
        String password = sc.next();

        //（二）.分别把用户名和密码写到本地文件。
        FileWriter fw = new FileWriter("d06_io\\a.txt");

        fw.write(username);     //用户名写入
        fw.write("\r\n");  //换行符写入
        fw.write(password);    //密码写入

        //刷新流
        fw.flush();
        //释放资源
        fw.close();
    }
}
