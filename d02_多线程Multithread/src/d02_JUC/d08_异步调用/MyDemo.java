package d02_JUC.d08_异步调用;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MyDemo {
    public static void main(String[] args) throws Exception {
        //异步调用无返回值
        CompletableFuture<Void> cf1 = new CompletableFuture<>().runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"-----cf1");
        });
        cf1.get();

        //异步调用有返回值
        CompletableFuture<Integer> cf2 = new CompletableFuture<>().supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"-----cf2");
            return 9527;
        });
        cf2.whenComplete((t,u)->{
            System.out.println("t="+t);     //t为返回值
            System.out.println("u="+u);     //u为异常信息
        }).get();
    }
}
