package d01_hehe.e05Semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {

    //1.new（同一个）管理员对象（参数表示最多允许线程执行数量）
    private Semaphore semaphore = new Semaphore(3);

    @Override
    public void run() {

        try {
            //2.获得通行证（没有就等）
            semaphore.acquire();

            //3.停车
            System.out.println(Thread.currentThread().getName()+"抢到了车位");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));    //随机时间停车

            //4.归还通行证
            System.out.println(Thread.currentThread().getName()+"------离开了车位");
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
