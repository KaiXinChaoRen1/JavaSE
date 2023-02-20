package d01_hehe.d03多线程实现3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * public FutureTask(Runnable runnable, V result) {
 */
public class Demo3 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "hehe");
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
