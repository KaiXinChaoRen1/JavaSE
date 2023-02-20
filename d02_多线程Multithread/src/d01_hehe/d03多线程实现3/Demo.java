package d01_hehe.d03多线程实现3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 接口callable方式
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建callable实现类的对象
        MyCallable mc = new MyCallable("小美");
        // 创建FutureTask<>对象
        FutureTask<String> ft = new FutureTask<>(mc);
        // 传入FutureTask<>对象ft做参数，创建线程对象
        Thread t1 = new Thread(ft);

        MyCallable mc2 = new MyCallable("大大大美");
        FutureTask<String> ft2 = new FutureTask<>(mc2);
        Thread t2 = new Thread(ft2);

        // 开启线程
        t1.start();
        t2.start();

        // 通过FutureTask<>对象ft获取结果
        String s = ft.get();
        System.out.println(s);

        String s2 = ft2.get();
        System.out.println(s2);
    }
}
