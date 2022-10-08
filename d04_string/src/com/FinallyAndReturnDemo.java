package com;

/**
 * try当中return  finally中仍然会执行
 */
public class FinallyAndReturnDemo {
    public static void main(String[] args) {
        FinallyAndReturnDemo my=new FinallyAndReturnDemo();
        System.out.println(my.getName("芜湖"));
    }
    public String getName(String name){
        String res="";
        try {
            res=name;
            return  res;
        } finally {
            res="大司马";
            return res;

        }
    }
}
