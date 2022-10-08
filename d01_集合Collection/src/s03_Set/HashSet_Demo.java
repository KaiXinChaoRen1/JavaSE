package s03_Set;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1.不重复（null值可以有一个）
 * 2.存取顺序不一致
 * （3.无操作索引方法）
 */

public class HashSet_Demo {
    public static void main(String[] args) {
        HashSet<String> mySet =new HashSet<>();
        //???????????????????????????????????????????????????
        System.out.println(mySet.add(new String("aa")));
        System.out.println(mySet.add(new String("aa")));
        //因为String重写了HashCode()和equals(),而hashset判断重复就是用的Hash()(hash算法用到hashcode)和equals()


    }
}
