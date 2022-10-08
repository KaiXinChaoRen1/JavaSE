package d01_hehe.d16阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列
 * 队列为空，获取操作会阻塞，队列中添加上元素时，阻塞的线程会被自动唤醒
 * 队列为满，添加操作会阻塞，元素被取走时，阻塞的线程会被自动唤醒
 * 好处在于：不需要关心什么时候阻塞线程，什么时候唤醒线程，都是自动的
 * put 和 take 方法的底层已加锁，但是我们写的输出语句在锁外边，所以会出现连着放连着吃的现象
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        //创建阻塞队列，参数为阻塞队列容量
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(1);


        Cooker c=new Cooker(abq);   //继承的方式创建线程
        Foodie f=new Foodie(abq);   //继承的方式创建线程

        c.start();
        f.start();


    }


}
