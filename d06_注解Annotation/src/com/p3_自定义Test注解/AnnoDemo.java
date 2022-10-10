package com.p3_自定义Test注解;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //1.通过反射获取UseTest类的字节码文件对象
        Class clazz = Class.forName("com.p3_自定义Test注解.UseTest");

        //创建对象
        UseTest useTest = (UseTest) clazz.newInstance();

        //2.通过反射获取这个类里面所有的方法对象
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {                 //遍历数组，得到每一个方法对象
            if(method.isAnnotationPresent(Test.class)){ //判断当前方法上是否有指定的注解。
                method.invoke(useTest);                 //运行
            }
        }
    }
}
