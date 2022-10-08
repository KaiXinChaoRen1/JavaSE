package d01_hehe.d14生产者消费者;

/**
 * 生产者造饭线程：
 *          0，判断是否吃饱
 *          1，判断桌子上是否有汉堡包
 *          2，如果有就等待，如果没有才生产。
 *          3，把汉堡包放在桌子上。
 *          4，叫醒等待的消费者开吃。
 * 注意：使用锁对象去调用等待和唤醒方法
 */
public class Cooker extends Thread {

    @Override
    public void run() {
        while(true){
            synchronized (Desk.lock){
                if(Desk.count == 10){
                    break;
                }else{
                    if(!Desk.flag){
                        System.out.println("老八正在制造小汉堡");
                        Desk.flag = true;
                        Desk.lock.notifyAll();
                    }else{
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
