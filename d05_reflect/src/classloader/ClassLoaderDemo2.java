package classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器加载资源文件
 */
public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //ClassLoader systemClassLoader = ClassLoaderDemo2.class.getClassLoader();

        //使用类加载器加载资源文件，参数：文件的路径;返回值：字节流
        InputStream is = systemClassLoader.getResourceAsStream("prop1.properties");

        Properties prop = new Properties();   //创建properties集合对象

        prop.load(is);                        //调用load方法加载流

        System.out.println(prop);

        is.close();
    }
}
