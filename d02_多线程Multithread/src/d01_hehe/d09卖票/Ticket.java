package d01_hehe.d09卖票;

/**
 * 线程锁
 * 同步代码块： synchronized (任意对象){多线程操作共享数据的代码 }
 * 默认情况下打开，当有一个线程进入，锁自动关闭，线程执行完出来，锁自动打开
 * 优点：解决了多线程下数据安全问题
 * 缺点：降低效率，浪费资源
 */
public class Ticket implements Runnable {

    private int ticket = 300;           //票的数量

    @Override
    public void run() {
        while(true){
            synchronized (this){     //多个线程必须使用同一把锁.
                if(ticket <= 0){
                    break;
                }else{
                    try {
                        Thread.sleep(20);      //模拟出票耗时
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            }
        }
    }
}

class Demo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();//同一个参数对象，同一百张票，给三个进程

        Thread t1 = new Thread(ticket,"售票员");
        Thread t2 = new Thread(ticket,"自动售货机");
        Thread t3 = new Thread(ticket,"经理");


        t1.start();
        t2.start();
        t3.start();
    }
}

