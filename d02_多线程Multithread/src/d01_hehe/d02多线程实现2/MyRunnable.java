package d01_hehe.d02多线程实现2;

public class MyRunnable implements Runnable {        //1.实现Runnable接口

    @Override
    public void run() {                              //2.重写run方法
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "第二种方式实现多线程" + i);
        }
    }
}
