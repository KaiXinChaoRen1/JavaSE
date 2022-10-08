package d02_JUC.d01_线程间通信_wait和notify;

/**
 * 如果是Lock
 * 要用lock.newCondition()方法获取condition对象
 * 在使用  condition.await()
 * 和      condition.signalAll()
 */
class Hehe{
    private int number=0;

    public synchronized void incr() throws InterruptedException {
        if (number!=0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"是："+number);
        this.notifyAll();
    }
    public synchronized void decr() throws InterruptedException {
        if (number!=1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"是："+number);
        this.notifyAll();
    }
}

public class Demohehe {

    public static void main(String[] args) {
        Hehe myhehe=new Hehe();
        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    myhehe.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    myhehe.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

    }
}
