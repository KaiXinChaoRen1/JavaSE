package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class S3_InsertSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1, -1, 89, -34, -3456, 8976, 0};
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));

       /* // 创建要给80000个的随机的数组 1s
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        insertSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);*/

    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int temp = 0;                               //变量后面要用，定义在外边
        int j = 0;
        for (int i = 1; i < arr.length; i++) {      //i从1开始，因为arr[0]只有一个数，看作有序
            temp = arr[i];                          //arr[i]是待插入的数，保存到该变量中
            j = i - 1;                              //待比较的下标（为i的前一个数开始）
            while (j >= 0 && temp < arr[j]) {       //比前一个数字小，说明位置不对
                arr[j + 1] = arr[j];                //前边那个数后移，让出位置
                j--;                                //待插入位置前移
            }
            //当退出while循环时，说明插入的位置j + 1（+1想想就明白了）,
            // 可以加一个判断，如果位置本来就对，就不用赋值了，缩小赋值次数，可能变快，实际没有
            arr[j + 1] = temp;
        }
    }

    //改成for循环
    public static void insertSort2(int[] arr) {
        int temp = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

}
