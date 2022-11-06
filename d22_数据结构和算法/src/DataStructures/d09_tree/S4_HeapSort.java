package DataStructures.d09_tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * 堆通常是一个可以被看做一棵完全二叉树的数组对象。
 * 堆总是满足下列性质：1.堆中某个结点的值总是不大于或不小于其父结点的值；2.堆总是一棵完全二叉树。
 * 大顶堆用于升序排列，反之反之
 * 平均时间复杂度O(nlogn)
 */
public class S4_HeapSort {
    public static void main(String[] args) {

        //测试
        int arr2[] = {9,0,-1,1,-9,333,222,999};
        heapSort(arr2);
        System.out.println("排序后=" + Arrays.toString(arr2));


        //测试
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);


    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int arr[]) {
        int temp = 0;
        for(int i = arr.length / 2 -1; i >=0; i--) {        //最后一个非叶子节点开始调整，结束后，整个数组（二叉树）变成一个大顶堆
            adjustHeap(arr, i, arr.length);
        }
//      将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
//　　	重新调整结构，使其满足堆定义，这次从0开始，因为0下面的已经符合大顶堆结构，可以从0开始调用adjustheap
//      然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for(int j = arr.length-1;j >0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将非叶子节点i的子树，调整成一个大顶堆（局部）
     * k = i * 2 + 1 k 是 i结点的左子结点
     * @param arr
     * @param i       表示非叶子节点在数组中的索引
     * @param length  对数组中多少元素调整（每次排出一个最大的，调整剩下的）
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];      //先取出当前元素的值，保存在临时变量
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k+1 < length && arr[k] < arr[k+1]) { //比较左子节点和右子节点，谁大k指向谁
                k++;        // k 指向右子结点，若不符合条件k指向左子节点（反正k指的是大的那个节点）
            }
            //上面单独一个if语句，下面if else一套
            if(arr[k] > temp) {         //大的子节点根temp比较（因为在第二次循环及以后，都是跟逻辑上替换后的父节点比较，而这个逻辑上替换后的父节点，就是一层层循环被替换下来的原根节点，而原根节点被保存在temp中）
                arr[i] = arr[k];        //把较大的值赋给当前结点
                i = k;                  //!!! i 指向 k,继续循环比较，调整使被交换而失去大顶堆性质的子节点恢复
            }
            else {                      //说明根大于左右，不用调整
                break;                  //从最后一个非叶子节点开始调整，如果某一个节点不用调整，就退出，以为它下面的已经调整过了
            }
        }
        //当for 循环结束，已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//目前i指向最后一个被调整的位置，
    }
}
