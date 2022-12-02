package com.d02_IO流.p06_properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * void store​(Writer writer, String comments) --- 将集合中的数据以键值对形式保存在本地
 */
public class PropertiesDemo4 {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        prop.put("zhangsan","123");
        prop.put("lisi","456");
        prop.put("wangwu","789");

        FileWriter fw = new FileWriter("d06_io\\prop.properties");

        prop.store(fw,"From the distinguished Oriental master -- Mr. Wen Qiang");    //第二个参数为注释信息

        fw.close();


    }
}
