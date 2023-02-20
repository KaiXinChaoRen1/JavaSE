package d01_hehe.d03多线程实现3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo2 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            for (int i = 0; i < 1000; i++) {
                //System.out.println("还有地虎侠");
                Thread.sleep(5);
            }
            return "他要召唤地虎铠甲";
        });
        new Thread(futureTask, "AAA").start();
        System.out.println("hehe");
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
        }

    }

}
