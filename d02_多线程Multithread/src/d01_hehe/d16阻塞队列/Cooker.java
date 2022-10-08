package d01_hehe.d16阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooker extends Thread{

    private ArrayBlockingQueue<String> abq;                         //成员变量
    public Cooker(ArrayBlockingQueue<String> abq) {
        this.abq=abq;
    } //构造方法

    public void run() {
        while (true) {
            try {
                abq.put("老八秘制小汉堡");
                System.out.println("老八造了一个小汉堡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
