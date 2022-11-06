package DataStructures.d07_search;

import java.util.Arrays;

public class S4_FibonacciSearch {

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};
        System.out.println("index=" + fibSearch(arr, 89));

    }

    public static int maxSize = 20;
    /**
     * 斐波那契数列获取方法
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    /**
     *斐波那契查找算法
     * @param a  数组
     * @param key 我们需要查找的关键码(值)
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;                  //表示斐波那契分割数值的下标
        int mid = 0;
        int f[] = fib();            //获取到斐波那契数列
        while(high > f[k] - 1) {    //获取到斐波那契分割数值的下标
            k++;
        }
        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需求使用a数组最后的数填充 temp
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for(int i = high + 1; i < temp.length; i++) {       //把填充的0改成最大值
            temp[i] = a[high];
        }
        while (low <= high) {       // 只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]) {   //继续查找(左边)
                high = mid - 1;
                k--;                //0、1、1、2、3、5、8、13、21、34。左边-1
            } else if ( key > temp[mid]) { //继续查找(右边)
                low = mid + 1;
                k -= 2;             //0、1、1、2、3、5、8、13、21、34。右边-2
            } else {                //找到
                if(mid <= high) {    //需要确定，返回的是哪个下标
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
