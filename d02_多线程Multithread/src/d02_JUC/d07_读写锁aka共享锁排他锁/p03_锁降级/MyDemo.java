package d02_JUC.d07_读写锁aka共享锁排他锁.p03_锁降级;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 获取写锁的线程在不释放写锁的情况下还能获取读锁
 *
 * 为什么？
 *      如果写数据完成后，释放锁，在试图读数据，可能会被别的写线程抢走
 *      那么等获取到读锁的时候，就读不到本线程上次写的数据了
 */
public class MyDemo {
    public static void main(String[] args) {
        ReadWriteLock rwLock=new ReentrantReadWriteLock();

        rwLock.writeLock().lock();   //获取写锁
        System.out.println("wwwwwwwwwwwwwwwww");
        rwLock.readLock().lock();    //获取读锁 （可以降级）
        System.out.println("rrrrrrrrrrrrrrrr");

        rwLock.writeLock().unlock(); //释放写锁（现在就成功降级成读锁了）
        rwLock.readLock().unlock();  //释放读锁

        rwLock.readLock().lock();    //获取读锁
        System.out.println("rrrrrrrrrrrrrr");
        rwLock.writeLock().lock();   //获取写锁 （不能升级）
        System.out.println("wwwwwwwwwwwwwwwwww");




    }
}
