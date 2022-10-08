package d01_hehe.e04CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class MotherThread extends Thread {

    private CountDownLatch countDownLatch;
    public MotherThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {

            countDownLatch.await();  //等待   当计数器变成0的时候，会自动唤醒这里等待的线程。

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2.收拾碗筷
        System.out.println(getName()+"在收拾碗筷");
    }
}
