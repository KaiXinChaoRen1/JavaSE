package d01_hehe.d02多线程实现2;

/**
 * 接口runnable方式,将runnable的实现类对象作为参数去创建线程
 *
 * lambda方法其实是简化的runable方法
 */
public class Demo {
    public static void main(String[] args) {
        //1.创建了一个Myrunnable参数的对象
        MyRunnable mr = new MyRunnable();

        //2.创建了一个线程对象,并把参数传递给这个线程，
        Thread t1 = new Thread(mr);

        //3.开启线程
        t1.start();


        MyRunnable mr2 = new MyRunnable();
        Thread t2 = new Thread(mr2);
        t2.start();

    }
}
