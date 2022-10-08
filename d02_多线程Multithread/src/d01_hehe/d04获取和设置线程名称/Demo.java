package d01_hehe.d04获取和设置线程名称;

/**
 * 线程名字
 */
public class Demo {
    //1,线程是有默认名字的,格式:Thread-编号
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("小蔡");
        t2.setName("小强");

        t1.start();
        t2.start();
    }
}
