package d01_hehe.e03原子操作类;

import java.util.concurrent.atomic.AtomicInteger;


public class MyAtomThread implements Runnable {
    /**
     * int get():   		         获取值
     * int getAndIncrement():     以原子方式将当前值加1，注意，这里返回的是自增前的值。
     * int incrementAndGet():     以原子方式将当前值加1，注意，这里返回的是自增后的值。
     * int addAndGet(int data):	 以原子方式将参数与对象中的值相加，并返回结果。
     * int getAndSet(int value):  以原子方式设置为newValue的值，并返回旧值。
     */
    AtomicInteger ac = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            count++的执行步骤:
//            1,从共享数据中读取数据到本线程栈中.
//            2,修改本线程栈中变量副本的值
//            3,会把本线程栈中变量副本的值赋值给共享数据.
//            (问题：非原子性，被打断会出现安全问题)
//            synchronized (lock) {     //锁可以解决，但是效率不高
//                count++;
//                ac++;
            int count = ac.incrementAndGet();
            System.out.println("已经送了" + count + "个冰淇淋");
           // }  （锁的反括号）
        }
    }
}
