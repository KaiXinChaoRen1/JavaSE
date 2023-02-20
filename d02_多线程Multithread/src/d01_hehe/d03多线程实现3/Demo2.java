package d01_hehe.d03多线程实现3;

import java.util.concurrent.FutureTask;

/**
 * FutureTask()参数可以是Callable<V> callable;
 */
public class Demo2 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            for (int i = 0; i < 1000; i++) {
                // System.out.println("还有地虎侠");
                Thread.sleep(5);
            }
            return "他要召唤地虎铠甲";
        });
        new Thread(futureTask, "AAA").start();

        try {
            // System.out.println("取消futureTask: " + futureTask.cancel(false));
            System.out.println("判断是否取消: " + futureTask.isCancelled());
            System.out.println("判断是否完成: " + futureTask.isDone());
            // 取消任务之后,再次获取任务的返回值会抛出CancellationException
            // get()方法是阻塞的
            System.out.println("获取返回值: " + futureTask.get());
            System.out.println("再次获取返回值: " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
