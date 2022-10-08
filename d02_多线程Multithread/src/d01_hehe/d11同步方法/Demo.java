package d01_hehe.d11同步方法;

/**
 * 同步方法锁对象是this
 * 同步静态方法锁对象是当前类的字节码文件对象
 */
public class Demo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();   //只创建一次

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}
