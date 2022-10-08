package d01_hehe.d14生产者消费者;

/**
 * 消费者老八线程：
 *         0，判断是否吃饱，吃饱就不吃了
 *         1，判断桌子上是否有汉堡包。
 *         2，如果没有就等待，如果有就开吃
 *         3，吃完之后，桌子上的汉堡包就没有了
 *         4，叫醒等待的生产者继续生产
 * 注意：使用锁对象去调用等待和唤醒方法
 */
public class Foodie extends Thread {
    @Override
    public void run() {

        while(true){
            synchronized (Desk.lock){
                if(Desk.count == 10){                       //吃十个老八才饱饱的
                    break;
                }else{
                    if(Desk.flag){                          //if桌子上有汉堡
                        System.out.println("干了兄弟们");    //开吃
                        Desk.flag = false;                  //吃完桌子上就没汉堡了
                        Desk.count++;                       //快饱了
                        Desk.lock.notifyAll();              //使用锁对象去调用唤醒all的方法
                    }else{                                  //else桌上没有汉堡堡
                        try {
                            Desk.lock.wait();               //使用锁对象去调用等待方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
