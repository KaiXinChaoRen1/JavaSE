package com.p3_自定义Test注解;

/**
 * 希望加了@Test的运行，没加的就不运行
 */
public class UseTest {

    public void show(){
        System.out.println("UseTest....show....");
    }

    @Test
    public void method(){
        System.out.println("我是UseTest的method方法，我有注解");
    }

    @Test
    public void function(){
        System.out.println("我是UseTest的function，我也有注解");
    }
}
