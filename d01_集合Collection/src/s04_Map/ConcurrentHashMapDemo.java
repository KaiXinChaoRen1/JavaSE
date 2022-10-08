package s04_Map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 不支持键和值为null，因为会有二义性问题
 * 值不为null ：HashMap可以用containsKey验证，因为是单线程
 * 多线程没法验证
 * 键不为null：兼容hashtable
 * hashtable键为什么不为null？
 * 作者认为键应该有hashcode 和equals方法，而null显然不符合
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap map=new ConcurrentHashMap();
    }
}
