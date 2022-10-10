package com.d02_io.p06_properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * properti跟IO相关的方法
 * void load​(Reader reader) ---- 将本地文件中的键值对数据读取到集合中
 */
public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {

        //创建properties对象
        Properties prop = new Properties();
        //创建字符输入流
        FileReader fr = new FileReader("d06_io\\prop.properties");
        //用properties对象中的load方法加载流
        prop.load(fr);
        //关闭流
        fr.close();

        System.out.println(prop);









    }
}
