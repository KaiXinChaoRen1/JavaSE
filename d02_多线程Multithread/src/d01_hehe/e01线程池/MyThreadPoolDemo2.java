package d01_hehe.e01线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor()
 * 一池子一线程
 */
public class MyThreadPoolDemo2 {
    public static void main(String[] args) throws InterruptedException {

        //创建线程池（内只能有一个线程）
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();

        try{
            //需要10个线程执行任务
            for (int i = 0; i < 10; i++) {
                //线程池创建一个线程，执行任务
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }
    }
}
