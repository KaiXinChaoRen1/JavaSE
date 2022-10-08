package d02_JUC.d07_读写锁aka共享锁排他锁.p02_加锁解决;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 加入读写锁后解决
 *
 * 写锁为独占锁，只有一个线程可以获得
 * 读锁为共享锁，多个线程可以获得（在这里可以提高效率）
 * 读锁和写锁不能同时获得
 *
 * 共享锁和独占锁都有可能会发生死锁
 *
 * 缺点：
 *      一直读，捞不着写，造成锁饥饿，可以通过设置读写锁的公平锁解决
 *
 **/
class Hehe{
    private volatile Map<String,Object> mymap = new HashMap<>();

    private ReadWriteLock rwlock=new ReentrantReadWriteLock();

    public void put(String key,Object value) {
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在写操作"+key);
            Thread.sleep(300);      //模拟操作耗时
            mymap.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写完了"+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }

    }

    public Object get(String key){
        Object res=null;
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取操作"+key);
            Thread.sleep(300);      //模拟操作耗时
            mymap.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完了"+key);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }
        return res;
    }

}

public class MyDemo02 {
    public static void main(String[] args) {
        Hehe myHe=new Hehe();
        for (int i = 1; i <=3 ; i++) {
            final int num=i;
            new Thread(()->{
                myHe.put(num+"",num+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=3 ; i++) {
            final int num=i;
            new Thread(()->{
                myHe.get(num+"");
            },String.valueOf(i)).start();
        }
    }
}
