package com.p1_常见注解;

/**
 * 注解是对程序的标注和解释
 * 给编译器和虚拟机看的
 */
//@SuppressWarnings(value = "all")  //表示压制了本类中所有的警告
public class Zi extends Fu {

    @Override   //告诉编译器这个方法是重写了父类的方法。
    public void show() {
        System.out.println("子类的方法");
    }


    @Deprecated     //表示这是一个过时的方法
    public void method(){
        System.out.println("method.......");
    }


    //@SuppressWarnings(value = "all")    //表示压制本方法中所有的警告
    public void function(){
        int a = 10;
        int b = 20;
        //System.out.println(a);    //不使用的话变量和方法会变灰色，是一种警告
        //System.out.println(b);
    }
}
