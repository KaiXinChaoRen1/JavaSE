package d01_hehe.d06线程休眠;

/**
 * 线程睡觉
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("睡觉前");
        Thread.sleep(3000);     //主线程休眠
        System.out.println("睡醒了");


        MyRunnable mr = new MyRunnable();   //Runnable实现多线程

        Thread t1 = new Thread(mr);         //创建线程对象
        Thread t2 = new Thread(mr);

        t1.start();                         //开启线程
        t2.start();
    }
}
