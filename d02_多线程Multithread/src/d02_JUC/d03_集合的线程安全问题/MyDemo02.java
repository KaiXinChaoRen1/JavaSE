package d02_JUC.d03_集合的线程安全问题;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 解决方案
 */
public class MyDemo02 {
    public static void main(String[] args) {

        //List<String> myList = new ArrayList<>();          //线程不安全，会出错误
        //List<String> myList = new Vector<>();             //方案一(古老)
        //List<String> myList= Collections.synchronizedList(new ArrayList<>());   //方案二（古老）
        List<String> myList = new CopyOnWriteArrayList<>(); //方案三（写时复制技术）（不古老）
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                myList.add(UUID.randomUUID().toString().substring(0,4));

                System.out.println(myList);

            },String.valueOf(i)).start();
        }

        Set<String> mySet = new CopyOnWriteArraySet<>();        //解决HashSet的线程不安全问题
        Map<String,String> myMap = new ConcurrentHashMap<>();   //解决HashMap的线程不安全问题
    }
}

//    底层用lock实现锁，而vector用synchronized 进行同步

//    读写分离，写时复制:
//        读操作还是在原始数组中进行（可多线程同时读）
//        写操作在一个复制的数组上进行，结束之后需要把原始数组指向新的复制数组。
//        写操作需要加锁，防止并发写入时导致写入数据丢失。
//        写操作的同时允许读操作，大大提高了读操作的性能，因此很适合"读多写少"的应用场景。
//
//
//    缺点：
//        内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
//        只能保证数据最终一致性，不能保证实时的一致性
