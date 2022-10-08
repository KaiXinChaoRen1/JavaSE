package d01_hehe.d06线程休眠;

/**
 * Thread.sleep(毫秒值);
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);           //如果类和接口里的方法没有抛出异常
            } catch (InterruptedException e) {       //那么他们的子类和实现类也不能抛出异常
                e.printStackTrace();                 //只能自己try catch
            }

            System.out.println(Thread.currentThread().getName() + "==" + i);
        }
    }
}


