package d01_hehe.d01多线程实现1;


public class Demo {
    public static void main(String[] args) {
        //创建一个线程对象
        MyThread t1 = new MyThread();
        //创建一个线程对象
        MyThread t2 = new MyThread();

        //t1.run();//表示常规创建对象,用对象去调用方法,并没有开启线程.
        //t2.run();


        //开启一条线程（是父类的方法，作用是启动线程，并调用run方法）
        t1.start();
        //开启第二条线程
        t2.start();
    }
}
