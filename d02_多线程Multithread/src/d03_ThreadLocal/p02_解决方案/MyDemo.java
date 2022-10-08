package d03_ThreadLocal.p02_解决方案;


import java.util.concurrent.SynchronousQueue;

/**
 * Synchronized：时间换空间，只有一份变量，多线程排队访问。侧重于同步访问
 * ThreadLocal ：空间换时间，每个线程都有一个变量副本 。  侧重于数据隔离
 */
class MySource{
    ThreadLocal<String> myThreadLocal=new ThreadLocal<>();
    private String value;

    public String getValue() {
        String str=myThreadLocal.get();
        return str;
    }

    public void setValue(String value) {
        myThreadLocal.set(value);
    }
}

public class MyDemo {
    public static void main(String[] args) {
        MySource mySource=new MySource();

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                mySource.setValue(Thread.currentThread().getName()+"的数据");
                System.out.println(Thread.currentThread().getName() + "---->" + mySource.getValue());
            },"线程"+i).start();
        }

    }
}
