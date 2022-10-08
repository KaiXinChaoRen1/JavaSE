package com.d01_自定义枚举类;

/**
 *  枚举类的使用：
 *  1.枚举类：类的对象是有限个，确定的。
 *  2.当需要定义一组常量的时候，强烈建议使用枚举类。
 *  3.如果枚举类只有一个对象，那么相当与单例模式的实现
 *
 * 如何定义枚举类？
 *      JDK1.5之前，自定义枚举类
 *      JDK1.5以后，enum关键字定义枚举类
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}
class Season{

    //1.声明枚举对象属性 private final 修饰
    private final String seasonName;
    private final String seasonDescription;

    //2.私有类的构造器 private
    private Season(String seasonName,String seasonDescription){
        this.seasonName=seasonName;
        this.seasonDescription=seasonDescription;
    }

    //3.提供当前枚举类的多个对象   public static final  所以后来eunm默认都是public static final
    public static final Season SPRING=new Season("春","困");
    public static final Season SUMMER=new Season("瞎","蚊");
    public static final Season AUTUMN=new Season("秋","乏");
    public static final Season WINTER=new Season("冬","冷");


    //4.其他诉求，例如toString
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDescription='" + seasonDescription + '\'' +
                '}';
    }
}
