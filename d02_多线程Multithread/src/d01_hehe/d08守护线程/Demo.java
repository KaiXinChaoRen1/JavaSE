package d01_hehe.d08守护线程;
/**
守护线程*/
public class Demo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        //把第二个线程设置为守护线程
        //当普通线程执行完之后,那么守护线程也没有继续运行下去的必要了.（也需要一会刹车时间）
        t2.setDaemon(true);



        t1.start();
        t2.start();
    }
}
