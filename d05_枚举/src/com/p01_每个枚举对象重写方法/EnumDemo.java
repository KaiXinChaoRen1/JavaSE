package com.p01_每个枚举对象重写方法;


public class EnumDemo {
    public static void main(String[] args) {


        System.out.println(Season.SPRING.getName()); //公有的get方法

        Season.SPRING.show();       //重写的show方法
    }
}
