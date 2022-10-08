package d01_hehe.d00_join;

/**
 * join()等待线程结束
 */
public class MyDemo {

    private static int a=0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(3000);
                a=10;
                System.out.println("我叫"+Thread.currentThread().getName()+",我先执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();


        Thread t2=new Thread(()->{
            try {
                t1.join();  //t2线程等t1线程执行完
                a=100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我叫"+Thread.currentThread().getName()+",我再执行");
        },"t2000");
        t2.start();


        t2.join();  //主线程等t2线程执行完
        System.out.println(a);
    }

}
