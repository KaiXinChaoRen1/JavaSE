package d01_hehe.d10继承Threa卖票;


public class MyThread extends Thread {
    private static int ticketCount = 100;       //这种方法需要两个mythread对象，所以要用static的票
    private static Object obj = new Object();   //还要用static的锁

    @Override
    public void run() {
        while(true){
            synchronized (obj){
                if(ticketCount <= 0){
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
                }
            }
        }
    }
}
