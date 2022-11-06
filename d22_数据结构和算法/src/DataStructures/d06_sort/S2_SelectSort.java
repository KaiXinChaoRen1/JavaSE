package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//选择排序
public class S2_SelectSort {

    public static void main(String[] args) {

/*        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));*/

        //创建要给80000个的随机的数组，3s
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }

    /**
     * 选择排序时间复杂度是 O(n^2)
     * 每轮找出一个最小的放在该轮的第一个，（从0开始）
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {          //从0开始，找最小的放到【0】的位置，再找剩下的最小的放到【1】的位置，依次类推
            int minIndex = i;                               //这两行代码，就是把剩下的数中第一个先当作最小的
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {      //写个循环，把我们当作最小的跟后面的比，找到真正最小的
                if (min > arr[j]) {                         //发现更小的
                    min = arr[j];                           //假定这个更小的是最小的
                    minIndex = j;                           //假定他的坐标就是最小的坐标
                }
            }                                               //出循环说明已找到最小的
            if (minIndex != i) {                            //把最小的跟该轮第一个（i），交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
