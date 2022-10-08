package d01_hehe.d05返回当前线程对象;

/**
 * 返回当前正在执行的线程对象
 */
public class Demo {
    public static void main(String[] args) {
                      //返回当前正在执行的线程对象
        Thread heheCurrentThread = Thread.currentThread();
        System.out.println(heheCurrentThread);

        String threadName = heheCurrentThread.getName();
        System.out.println(threadName);
    }
}
