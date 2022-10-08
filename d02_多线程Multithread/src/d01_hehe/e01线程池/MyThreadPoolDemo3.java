package d01_hehe.e01线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *newCachedThreadPool()
 * 一池可扩容线程

 */
public class MyThreadPoolDemo3 {
    public static void main(String[] args) throws InterruptedException {

        //创建可扩容线程池
        ExecutorService threadPool1 = Executors.newCachedThreadPool();

        try{
            //需要10个线程执行任务
            for (int i = 0; i < 20; i++) {
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
