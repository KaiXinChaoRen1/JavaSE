package com.p01_枚举类特点;


public class EnumDemo {
    public static void main(String[] args) {


        System.out.println(Season.AUTUMN.getName()); //公有的get方法

        Season.WINTER.show();       //重写的show方法
    }
}
