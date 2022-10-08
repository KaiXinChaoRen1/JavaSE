package d01_hehe.d16阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

class MyResource{

    private ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<>(1);

    private volatile int eatCount=0;

    public void makeFood() throws InterruptedException {
        while (true){
            abq.put("小汉堡");
            System.out.println("制作汉堡");
        }

    }
    public void eatFood() throws InterruptedException {
        while (true){
            abq.take();
            eatCount++;
            System.out.println("吃汉堡");
        }

    }
}

public class Hehe {
    public static void main(String[] args) {

        MyResource myResourcer=new MyResource();


        new Thread(()->{
            try {
                myResourcer.makeFood();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                myResourcer.eatFood();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
