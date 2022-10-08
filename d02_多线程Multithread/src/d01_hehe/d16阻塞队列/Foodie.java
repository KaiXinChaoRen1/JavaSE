package d01_hehe.d16阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {

    private ArrayBlockingQueue<String> abq;                             //成员变量
    public Foodie(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }   //构造方法

    public void run() {
        while (true){
            try {
                String take = abq.take();
                System.out.println("老八拿出了一个" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
