package d02_JUC.d06_可重入锁;

/**

 * 可重入锁，指的是以线程为单位，当一个线程获取对象锁之后，这个线程可以再次获取本对象上的锁，而其他的线程是不可以的。
 * synchronized 和   ReentrantLock 都是可重入锁。
 * 可重入锁的意义之一在于防止死锁。
 * 实现原理实现是通过为每个锁关联一个请求计数器和一个占有它的线程。当计数为0时，认为锁是未被占有的；
 * 线程请求一个未被占有的锁时，JVM将记录锁的占有者，并且将请求计数器置为1 。
 * 如果同一个线程再次请求这个锁，计数器将递增；
 * 每次占用线程退出同步块，计数器值将递减。直到计数器为0,锁被释放。
 */
public class MyDemo {

    public synchronized void method(){
        method();
    }
    public static void main(String[] args) {

        new MyDemo().method();

        /*Object o=new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }

        },"AA").start();*/


    }
}
