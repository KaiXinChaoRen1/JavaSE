package com;

public class StringDemo {
    public static void main(String[] args) {

        String s="hello";
        s=s+"world";                //字符串使用+进行拼接。底层调用Stringbuilder再toString，所以不在常量池
        System.out.println(s);

        String s1="hello"+"world";  //字符串常量进行拼接时，有常量优化机制，在编译时就拼接好了，相当于=后面就是"helloworld"
        System.out.println(s1);

        String s2="helloworld";     //先检查常量池，有就直接指向，否则在常量池中创建
        System.out.println(s2);

        String s3=new String("helloworld"); //new出来的对象在堆内存

        System.out.println(s1==s2);     //s1和s2都在常量池
        System.out.println(s==s1);      //s在堆内存，s1在常量池
        System.out.println(s==s3);      //堆内存中的两个不同对象
        System.out.println(s1==s3);     //s3在堆内存，s1在常量池

        System.out.println("----------------------");

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            System.out.println(c);  //按照索引获取字符
        }

    }
}
