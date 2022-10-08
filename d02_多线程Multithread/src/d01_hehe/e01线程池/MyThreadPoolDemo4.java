package d01_hehe.e01线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 《阿里巴巴开发手册》讲，我们要用线程池就用我们自定义的。
 *
 * 线城池-----------7个参数
 * int corePoolSize,                       常驻线程数量
 * int maximumPoolSize,                    最大线程数
 * long keepAliveTime,                     空闲线程（扩容出来的）最大存活时间的‘值’
 * TimeUnit unit,                          空闲线程最大存活时间‘单位’
 * BlockingQueue<Runnable> workQueue,      阻塞队列（线程不够用，请求放进去）0

 * ThreadFactory threadFactory,            线程工厂（创建线程）
 * RejectedExecutionHandler handler        拒绝策略 （当任务提交数 > 池最大线程数+阻塞队列 时触发）
 *                                                  四种策略（报异常，把新任务退回，抛弃等待最久，不处理）
 *

 */
public class MyThreadPoolDemo4 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor mypool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),

                new ThreadPoolExecutor.AbortPolicy()
        );

        mypool.submit(new MyRunnable());

        mypool.submit(new MyRunnable());

        mypool.shutdown();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在执行了");
    }
}
