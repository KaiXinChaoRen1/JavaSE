package d01_hehe.d07线程抢占优先级;
/**
 * Java中进行抢占式调度模型，优先级为1 - 10默认值为5，优先级高抢占cpu几率高，优先级相同则随机
 */

import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) {

        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);

        Thread t1 = new Thread(ft);
        t1.setName("飞机");
        //System.out.println(t1.getPriority());//获取线程优先级，默认是5
        t1.setPriority(10);     //设置线程优先级
        t1.start();




        MyCallable mc2 = new MyCallable();

        FutureTask<String> ft2 = new FutureTask<>(mc2);

        Thread t2 = new Thread(ft2);
        t2.setName("坦克");
        t2.setPriority(1);
        t2.start();
    }
}
