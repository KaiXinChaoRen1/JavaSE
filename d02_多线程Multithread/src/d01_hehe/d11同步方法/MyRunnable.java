package d01_hehe.d11同步方法;

public class MyRunnable implements Runnable {

    private static int ticketCount = 100;

    @Override
    public void run() {
        while(true){
            //窗口一调用同步方法
            if("窗口一".equals(Thread.currentThread().getName())){
                boolean result = synchronizedMethod();
                if(result){
                    break;
                }
            }
            //窗口二执行同步代码块
            if("窗口二".equals(Thread.currentThread().getName())){
                //同步代码块
                //synchronized (MyRunnable.class){//同步静态方法，锁对象是当前类.class
                synchronized (this){
                    if(ticketCount == 0){
                       break;
                    }else{
                        try {
                            Thread.sleep(10);       //模拟出票
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticketCount--;
                        System.out.println(Thread.currentThread().getName() + "使用同步代码块卖了一张票,还剩下" + ticketCount + "张票");
                    }
                }
            }

        }
    }

    //同步的代码可以抽取在一个方法里，不妨声明一个同步方法
    private /*static*/ synchronized boolean synchronizedMethod() {
        if(ticketCount == 0){
            return true;
        }else{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "调用synchronized方法卖了一张票,还剩下" + ticketCount + "张票");
            return false;
        }
    }
}
