package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 直接插入排序有个不足之处是当一个数组是十分无序的状态时，排序的时间复杂度较久。
 * 特别是要将一个逆序的数组排为顺序的数组，这个逆序的数组相当于完全无序的，而直接插入排序需要的时间久。
 * （数据多时，且无序）而如何使排序时间减少呢，那么对数据有一定的要求，那就是基本有序。
 * 利用希尔排序，可以使数据先基本有序，然后在利用直接插入法。
 * 直接插入排序在数据量少时效率还是挺高的，所以就先将数组分开一小组一小组的排，最后使得整个数组是基本有序状态，
 * 再用一次直接插入排序法即可。
 */
public class S4_ShellSort {
    public static void main(String[] args) {

/*        int[] arr = {8, 9, 1, 7, 2, 3, 4, 0, -5, -1, 99,-333};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));*/

        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort3(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }


    /**
     * 交换法希尔排序
     * 老韩写的垃圾
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {  // 如果当前元素大于加上步长后的那个元素，要交换
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 先分组再插入排序，我的杰作
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {  //希尔的分组
            for (int i = gap; i < gap + gap; i++) {            //遍历这些组的第二个数，为每个组做插入排序
                int temp = 0;
                int index = 0;
                for (int j = i; j < arr.length; j += gap) {
                    temp = arr[j];
                    for (index = j - gap; index >= 0 && temp < arr[index]; index -= gap) {
                        arr[index + gap] = arr[index];
                    }
                    arr[index + gap] = temp;
                }
            }
        }
    }

    /**
     * 我的杰作，2.0
     * @param arr
     */
    public static void shellSort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {  //希尔的分组
            for (int i = 0; i < gap; i++) {            //遍历这些组的第一个数，为每个组做插入排序
                int temp = 0;
                int index = 0;
                for (int j = i+gap; j < arr.length; j += gap) {
                    temp = arr[j];
                    for (index = j - gap; index >= 0 && temp < arr[index]; index -= gap) {
                        arr[index + gap] = arr[index];
                    }
                    arr[index + gap] = temp;
                }
            }
        }
    }


}
