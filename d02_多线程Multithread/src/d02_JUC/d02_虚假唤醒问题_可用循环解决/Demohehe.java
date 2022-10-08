package d02_JUC.d02_虚假唤醒问题_可用循环解决;

/**
 * 资源类
 */
class Hehe{
    private int number=0;

    public synchronized void incr() throws InterruptedException {
 /*       if (number!=0) {
            this.wait();    //释放锁，哪里睡就哪里醒（这里醒了就少了判断，所以要放到while中）
        }*/
        while (number!=0) {
            this.wait();    //释放锁，哪里睡就哪里醒（这里醒了就少了判断，所以要放到while中）
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"是："+number);
        this.notifyAll();
    }


    public synchronized void decr() throws InterruptedException {
        while (number!=1) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"是："+number);
        this.notifyAll();
    }
}

/**
 * 业务类
 */
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

        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    myhehe.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    myhehe.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

    }
}
