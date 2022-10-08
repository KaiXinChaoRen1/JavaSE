package d01_hehe.d12Lock锁;

/**
 * 手动上下锁
 */
public class Demo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket,"售票员黄渤");
        Thread t2 = new Thread(ticket,"售票员孙红雷");
        Thread t3 = new Thread(ticket,"售票员罗志祥");


        t1.start();
        t2.start();
        t3.start();
    }
}
