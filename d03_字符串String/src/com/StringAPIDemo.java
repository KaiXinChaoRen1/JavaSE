package com;

public class StringAPIDemo {
    public static void main(String[] args) {
        System.out.println("------------------分割字符串");
        String str="a,b,c,d";
        String[]  arr = str.split(",");

        for (String s : arr) {
            System.out.println(s);
        }

        System.out.println("------------------valueOf");
        char[] chars=new char[]{'a','b','c'};
        String s1 = String.valueOf(chars);
        String s2 = String.valueOf(314);
        String s3 = String.valueOf(314L);
        String s4 = String.valueOf(3.14);
        String s5 = String.valueOf(3.14F);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);


        System.out.println("--------最好用大写,因为小写看不清");
        float f1=3.14f;
        float f2=3.14F;
        System.out.println(f1);
        System.out.println(f2);
        Long l1=341l;
        Long l2=341L;
        System.out.println(l1);
        System.out.println(l2);











    }


}
