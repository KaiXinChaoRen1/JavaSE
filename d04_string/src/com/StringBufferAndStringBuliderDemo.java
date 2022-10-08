package com;

/**
 * String   不可变字符序列
 * StringBuffer 可变字符序列
 *      线程安全，内部是同步方法；但效率较低
 *      可变是因为没有private final修饰
 *      初始数组容量为定义的字符数+16
 *      扩容：扩容一倍再+2；如果还不够就加到正好
 * StringBuilder可变字符序列
 *
 * JDK9之后 底层变成byte数组
 */
public class StringBufferAndStringBuliderDemo {
    public static void main(String[] args) {

    }
}
