package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class S5_QuickSort {
    public static void main(String[] args) {

        /*int[] arr = {8, 9, 1, 7, 2, 3, 4, 0, -5, -1, 91,-89,987};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));*/

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

        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {              //防止不合法
            return;
        }
        int base = arr[left];            //把传进来的数组左边第一个当作基准数
        int i = left;
        int j = right;
        while (i != j) {                  //用循环进行检索，事先不知道循环次数，所以用while循环
            //先让j从右往左检索，遇到比基数小的停下，大or相等就继续检索（左移）
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            //代码出了两个循环走到这里，说明都停下了，需要交换
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //出这个循环，说明i，j相遇，要交换此位置元素与基数元素
        arr[left] = arr[i];
        arr[i] = base;
        //此时基数左右已经都比基数小或者大了
        //再递归调用，排左部分
        quickSort(arr,left,i-1);
        //排右部分
        quickSort(arr,i+1,right);
    }
}