package com.p02_枚举类常见方法;

public class EnumDemo {
        public static void main(String[] args) {
                // String name() 获取枚举项的名称
                String name = Season.SPRING.name();
                System.out.println(name);
                System.out.println("-----------------------------");

                // int ordinal() 返回枚举项在枚举类中的索引值
                System.out.println(Season.SPRING.ordinal());
                System.out.println(Season.SUMMER.ordinal());
                System.out.println(Season.AUTUMN.ordinal());
                System.out.println(Season.WINTER.ordinal());
                System.out.println("-----------------------------");

                // int compareTo(E o) 比较两个枚举项，返回的是索引值的差值
                int result = Season.SPRING.compareTo(Season.WINTER);
                System.out.println(result);// -3
                System.out.println("-----------------------------");

                // String toString() 返回枚举常量的名称
                String s = Season.SPRING.toString();
                System.out.println(s);
                System.out.println("-----------------------------");

                // static <T> T valueOf(Class<T> type,String name)
                // 获取指定枚举类中的指定名称的枚举值
                Season spring = Enum.valueOf(Season.class, "SPRING");
                System.out.println(spring);
                System.out.println(Season.SPRING == spring);
                System.out.println("-----------------------------");

                // values() 获得所有的枚举项
                Season[] values = Season.values();
                for (Season value : values) {
                        System.out.println(value);
                }

        }
}
