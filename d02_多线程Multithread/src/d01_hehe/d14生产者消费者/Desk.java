package d01_hehe.d14生产者消费者;

public class Desk {

    //定义一个标记
    //true 就表示桌子上有汉堡包的,此时允许吃货执行
    //false 就表示桌子上没有汉堡包的,此时允许厨师执行
    public static boolean flag = false;

    //锁对象（同一个桌子，同一个撤硕，同一把锁）
    public static final Object lock = new Object();

    //老能能吃饱汉堡包的数量
    public static int count = 0;


}
