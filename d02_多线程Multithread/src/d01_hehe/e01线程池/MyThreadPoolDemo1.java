package d01_hehe.e01线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool(int nThreads)
 * 一池n线程(n通过构造函数指定)
 *
 *
 * execute只能提交Runnable类型的任务,
 * 而submit既能提交Runnable类型任务也能提交Callable类型任务
 */
public class MyThreadPoolDemo1 {
    public static void main(String[] args) throws InterruptedException {

        //创建线程池（5个）
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        try {
            //需要10个线程执行任务
            for (int i = 0; i < 10; i++) {
                //线程池创建一个线程，执行任务
                threadPool1.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }
    }
}
