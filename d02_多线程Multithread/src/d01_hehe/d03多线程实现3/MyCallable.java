package d01_hehe.d03多线程实现3;

import java.util.concurrent.Callable;
                                            //泛型是返回值的类型
public class MyCallable implements Callable {
    private String nvshen;

    //构造方法
    public MyCallable(String s){
        nvshen=s;
    }
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("跟"+nvshen+"表白" + i+"次");
        }
        //返回值就表示线程运行完毕之后的结果
        return nvshen+"答应";
    }
}


/**
 * 一。实现接口的两种方式区别：有无返回值,是否能抛出异常（callable可以）。
 *
 * 二。实现接口与继承类的区别：1.接口方式： 优点是 扩展性强，实现接口还可以继承其他类，
 *                                缺点是 编程复杂且由于不继承Thread不能直接使用thread类的方法
 *
 *                         2.继承方式：反过来（一般不继承，因为java单继承，继承很珍贵）
*/
