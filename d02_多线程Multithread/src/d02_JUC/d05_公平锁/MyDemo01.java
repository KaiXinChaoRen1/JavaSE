package d02_JUC.d05_公平锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁，雨露均沾，效率相对较低
 */
class Ticket{
    private int tickets=30;
    //Lock myLock=new ReentrantLock();          //默认非公平锁
    Lock myLock=new ReentrantLock(true);   //参数为true公平锁
    public void sale(){
        myLock.lock();
        try {
            if(tickets>0){
                tickets--;
                System.out.println(Thread.currentThread().getName()+"卖出一张，还剩"+tickets+"张");
            }
        } finally {
            myLock.unlock();
        }
    }
}

public class MyDemo01 {
    public static void main(String[] args) {
        Ticket myt=new Ticket();
        new Thread(()->{
            for (int i = 0; i <30 ; i++) {
                myt.sale();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <30 ; i++) {
                myt.sale();
            }
        },"BB").start();
    }
}
