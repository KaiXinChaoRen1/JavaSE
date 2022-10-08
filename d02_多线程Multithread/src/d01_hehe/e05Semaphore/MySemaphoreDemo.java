package d01_hehe.e05Semaphore;

public class MySemaphoreDemo {
    public static void main(String[] args) {

        MyRunnable mr = new MyRunnable();

        for (int i = 0; i < 8; i++) {       //创建8个线程执行
            new Thread(mr,String.valueOf(i)+"线程").start();
        }
    }
}
