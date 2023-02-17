package com.p01_枚举方法;


public class EnumDemo {
    public static void main(String[] args) {


        System.out.println(Season.SPRING.getName()); //公有的get方法

        Season.SPRING.show();       //重写的show方法
    }
}
