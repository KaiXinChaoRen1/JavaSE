package d01_hehe.e04CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch使用场景：
 *      一条线程等待其他线程执行完毕之后再执行
 */
public class MyCountDownLatchDemo {
    public static void main(String[] args) {
        //1.创建CountDownLatch的对象，需要传递给四个线程。
        //在底层就定义了一个计数器，此时计数器的值就是3
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //2.创建四个线程对象并开启他们。
        MotherThread motherThread = new MotherThread(countDownLatch);
        motherThread.setName("麻麻( •̀ ω •́ )y");

        ChileThread1 t1 = new ChileThread1(countDownLatch);
        t1.setName("三弟");

        ChileThread2 t2 = new ChileThread2(countDownLatch);
        t2.setName("二哥");

        ChileThread3 t3 = new ChileThread3(countDownLatch);
        t3.setName("大哥");

        motherThread.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
