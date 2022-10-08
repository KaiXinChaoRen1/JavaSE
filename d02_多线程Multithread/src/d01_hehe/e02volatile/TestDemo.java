package d01_hehe.e02volatile;


import java.util.concurrent.TimeUnit;

/**
 * 模拟不出来问题啊。。。。。服了
 *
 * 解决线程间变量的可见性
 * 不保证原子性
 */
public class TestDemo {
      //全局共享变量，标识状态
        private static volatile boolean is = true;

       public static void main(String[] args) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   int i = 0;
                   while (TestDemo.is){
                       i++;
                   }
                   System.out.println(i);
               }
           }).start();


           try {
               //停止2秒种
               TimeUnit.SECONDS.sleep(1);
           }catch (InterruptedException e) {
               e.printStackTrace();
           }
           //设置is为false，使得上面的while线程结束循环
           TestDemo.is = false;
           System.out.println("被置为了false了。");
       }




}
