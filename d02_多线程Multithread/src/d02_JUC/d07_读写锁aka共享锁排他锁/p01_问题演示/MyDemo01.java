package d02_JUC.d07_读写锁aka共享锁排他锁.p01_问题演示;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题演示
 */
class Hehe{
    private volatile Map<String,Object> mymap = new HashMap<>();

    public void put(String key,Object value) {
        System.out.println(Thread.currentThread().getName()+"正在写操作"+key);
        try {
            Thread.sleep(300);      //模拟操作耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mymap.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写完了"+key);
    }
    public Object get(String key){
        System.out.println(Thread.currentThread().getName()+"正在读取操作"+key);
        try {
            Thread.sleep(300);      //模拟操作耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object res=mymap.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完了"+key);
        return res;
    }

}
public class MyDemo01 {
    public static void main(String[] args) {

        Hehe myHe=new Hehe();

        for (int i = 1; i <=3 ; i++) {
            final int num=i;
            new Thread(()->{
                myHe.put(num+"",num+"");
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <=3 ; i++) {
            final int num=i;
            new Thread(()->{
                myHe.get(num+"");
            },String.valueOf(i)).start();
        }

        /**
         *问题是没写完就先读完了
         */
    }
}
