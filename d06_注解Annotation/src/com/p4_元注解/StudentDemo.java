package com.p4_元注解;

public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到子类的字节码文件对象
        Class clazz = Class.forName("com.p4_元注解.Student");

        //判断是否有注解。
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}
