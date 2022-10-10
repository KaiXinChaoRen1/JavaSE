package com.p4_元注解;

import java.lang.annotation.*;

/**
 * 在JDK 1.5中提供了4个标准的用来对注解类型进行注解的注解类，
 * 我们称之为 meta-annotation（元注解）
 */
//指定注解使用的位置（成员变量，类，方法）
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
//指定该注解的存活时间为运行时(不写的话，默认只在java文件中存活)
@Retention(RetentionPolicy.RUNTIME)
//指定注解可以被继承
@Inherited
public @interface Anno {
}
