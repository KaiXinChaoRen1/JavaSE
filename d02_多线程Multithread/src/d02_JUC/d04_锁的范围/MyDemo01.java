package d02_JUC.d04_锁的范围;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * synchronized3 种形式。
 * 修饰普通方法，锁是当前实例对象。
 * 修饰静态方法，锁是当前类的.Class对象。
 * 同步代码块，锁是括号里咱定的的对象
 * <p>
 * 以静态同步方法与非静态同步方法之间是不会有竞态条件的。
 */
class Phone {

    public synchronized void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----send短信");
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println("-----send邮件");
    }

    public void getHello() {
        System.out.println("-----getHello");
    }
}

public class MyDemo01 {
    public static void main(String[] args) throws InterruptedException {

        Phone p = new Phone();

        new Thread(() -> {
            try {
                p.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "AA").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                p.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "BB").start();

    }
}
