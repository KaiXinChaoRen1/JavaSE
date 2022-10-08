package d01_hehe.d13死锁;

/**
 * 死锁
 * 原因：锁的嵌套
 * 解决：别写锁嵌套
 */
public class Demo {
    public static void main(String[] args) {

        Object objA = new Object();
        Object objB = new Object();

        new Thread(() -> {
            synchronized (objA) {
                System.out.println("已获取A锁,想要获取B锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objB) {

                }

            }
        }).start();

        new Thread(() -> {

            synchronized (objB) {
                System.out.println("已获取B锁,想要获取A锁");
                synchronized (objA) {

                }
            }

        }).start();
    }
}
