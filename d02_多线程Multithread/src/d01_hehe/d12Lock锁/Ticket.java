package d01_hehe.d12Lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 相同：
 * 两者都是可重入锁 “可重入锁” （自己可以再次获取自己的内部的锁）。
 * 比如一个线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的。
 * 同一个线程每次获取锁，锁的计数器都自增 1，所以要等到锁的计数器下降为 0 时才能释放锁。

 * 区别：
 * synchronized是依赖于 JVM 实现的，是java的关键字，Lock是API层面实现的，是个接口
 * Lock比synchronized更灵活，功能更多 例如：
 *           1.ReentrantLock提供了一种能够中断等待锁的线程的机制，通过 lock.lockInterruptibly() 来实现这个机制。也就是说正在等待的线程可以选择放弃等待，改为处理其他事情。
 *           2.可实现公平锁（公平锁就是先等待的线程先获得锁）synchronized是非公平锁。ReentrantLock默认情况是非公平的，带参构造可指定公不公平。
 * synchronized出现异常会自动释放锁，Lock不会，所以使用时需要在finally中释放锁
 *
 */
public class Ticket implements Runnable {

    private int ticket = 3000;
    private Lock mylock = new ReentrantLock();   //可重入锁  Lock接口下还有读锁和写锁

    @Override
    public void run() {
        while (true) {
            try {
                mylock.lock();        //**手动加锁**
                if (ticket <= 0) {
                    break;
                } else {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mylock.unlock();      //**手动解锁** （放到finally中防止出现异常而不能释放锁）

            }

        }
    }
}
