package com.d02_io.p06_properties;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * properties
 *      是一个map集合
 *      有两个跟io相关的方法
 *      无泛型，可存任意类型，但一般存字符串
 */
public class PropertiesDemo1 {
    public static void main(String[] args) {
        //创建对象
        Properties prop = new Properties();

        //增
        prop.put("小龙女","尹志平");
        prop.put("郭襄","杨过");
        prop.put("黄蓉","欧阳克");
        System.out.println(prop);

        //删
        prop.remove("郭襄");
        System.out.println(prop);

        //改
        //put --- 如果键不存在,那么就添加,如果键存在,那么就覆盖.
        prop.put("小龙女","杨过");
        System.out.println(prop);

        //查
        Object value = prop.get("黄蓉");
        System.out.println(value);

        //遍历
        Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            Object value2 = prop.get(key);
            System.out.println(key + "=" + value2);
        }

        System.out.println("========================");

        //装的是所有的键值对对象.
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value3 = entry.getValue();
            System.out.println(key + "=" + value3);
        }

    }
}
