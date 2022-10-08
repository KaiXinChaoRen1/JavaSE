package s04_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * HashMap使用Key的哈希值，对应的存放到数组的“指定位置”上，节点应该尽可能均匀地分布在数组上，
 * 所以会用Key的哈希值对数组长度取模来作为这个“目标位置”。
 * 比如：一个Key的 hashCode() 是 1029991，此时HashMap内部的数组长度16，
 * 那么这个Key被存放在数组的第 1029991 % 16 = 7 位上。
 * 而取模运算本身是有一定的优化空间的，   X % b == X & (b - 1)      （前提是b为2^n）
 * 位运算的性能要好很多
 * 所以，HashMap的开发者想要优化下这个取模运算的速度，那么他就需要把HashMap内部的数组长度固定为 2^n 的长度了，
 * 也就是说HashMap里面的数组的长度，始终都是2的n次幂。为了实现这个效果，它的扩容因子很自然就是2倍了。
 *
 * 为什么？X % b == X & (b - 1)      （前提是b为2^n）
 * 答：
 *      X/2     相当于右移一位
 *      X/2^n   相当于右移n位，被移走的n位就是除法的余数
 *      所以X对2^n取余相当于求x的后n位
 *
 *      2^n相当于二进制第一个是1，后n个都是0
 *      (2^n)-1相当于二进制的第一个是0，后n个都是1
 *      X & ((2^n)-1) 相当于取X的二进制的后n位
 *
 *      所以 X%2^n  ==  x&((2^n)-1)
 *
 */
public class MapDemo {
    public static void main(String[] args) {

    }
}
