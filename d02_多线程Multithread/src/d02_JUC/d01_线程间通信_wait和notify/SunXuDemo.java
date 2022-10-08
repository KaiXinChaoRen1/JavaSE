package d02_JUC.d01_线程间通信_wait和notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间的定制化通信
 */
class ShareResource {

    private int flag = 1;

    private ReentrantLock myLock = new ReentrantLock();

    private Condition c1=myLock.newCondition(); //不知道为什么必须先写前边的，险些后面的idea不提示
    private Condition c2=myLock.newCondition();
    private Condition c3=myLock.newCondition();

    public void Meng(){
        myLock.lock();

        try{
            while(flag!=1){
                c1.await();
            }
            System.out.println(Thread.currentThread().getName()+"--暴风星云裂");
            flag=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }
    public void Pi(){
        myLock.lock();

        try{
            while(flag!=2){
                c2.await();
            }
            System.out.println(Thread.currentThread().getName()+"--雷霆半月斩");
            flag=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }
    public void Li(){
        myLock.lock();

        try{
            while(flag!=3){
                c3.await();
            }
            System.out.println(Thread.currentThread().getName()+"--泰山陨石坠");
            flag=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }


}

public class SunXuDemo {
    public static void main(String[] args) {
        ShareResource mySR=new ShareResource();
        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                mySR.Meng();
            }
        },"AA线程").start();

        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                mySR.Pi();
            }
        },"BB线程").start();


        new Thread(()->{
            for (int i = 0; i <3 ; i++) {
                mySR.Li();
            }
        },"CC线程").start();
    }
}
