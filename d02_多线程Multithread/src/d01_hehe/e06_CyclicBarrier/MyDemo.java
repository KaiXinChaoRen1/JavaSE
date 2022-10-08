package d01_hehe.e06_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏（有指定线程数await后才调用指定方法）
 */
public class MyDemo {
    public static void main(String[] args) {

        CyclicBarrier ccb=new CyclicBarrier(7 , ()->{
            System.out.println("神龙：你们集齐了七颗龙珠，我来实现你们的愿望");
        });

        for (int i = 1; i <=7 ; i++) {      //创建七个线程
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"星龙珠已经拿下"); //每个线程干活
                try {
                    ccb.await();                                                     //干完活等待
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }
    }
}
