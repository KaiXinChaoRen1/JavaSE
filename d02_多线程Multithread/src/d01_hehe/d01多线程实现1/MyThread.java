package d01_hehe.d01多线程实现1;


public class MyThread extends Thread{       //1.继承Thread类，
    @Override
    public void run() {                     //2.实现run方法
        for (int i = 1; i <= 10; i++) {     //run方法内代码就是线程在开启之后要执行的
            System.out.println(Thread.currentThread().getName()+"正在打第" + i+"个人");
        }
    }
}
