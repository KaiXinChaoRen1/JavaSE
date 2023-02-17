package com.d02_IO流.p05_转换流;

import java.io.*;

/**
 * 对象操作流：对象以字节的形式写入
 */
public class ConvertedDemo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将这个对象保存到本地
        User user = new User("zhangsan","123abc");

        //创建对象输出流，并传入字节输出流对象来关联文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d06_io\\b.txt"));
        //调用方法，将对象写出
        oos.writeObject(user);
        //close
        oos.close();


        //创建对象输入流，并传入字节输入流对象来关联文件
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d06_io\\b.txt"));
        //读入对象，返回对象
        User o = (User) ois.readObject();
        //打印看看
        System.out.println(o);
        //close
        ois.close();


    }
}
