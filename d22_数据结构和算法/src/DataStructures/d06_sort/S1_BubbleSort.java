package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * 如果有五个数，第一趟两两相比，比四次，确定一个最大的在最后，然后只需要再排前面四个即可
 * 同理，前四个第二趟两两相比，比三次。
 */
public class S1_BubbleSort {

    public static void main(String[] args) {

        int arr[] = {488,96,3, 9, -1, 10, 20,-99,0,21};
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));


        /*//测试一下冒泡排序的速度O(n^2), 给80000个数据，测试。10s
        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);*/

    }


    /**
     * 时间复杂度 O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;               // 临时变量
        for (int i = 0; i < arr.length - 1; i++) {              //控制比较轮数，
            for (int j = 0; j < arr.length - 1 - i; j++) {      //控制比较次数，轮数多一轮，需要比的次数少一个
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 优化一下，没啥屌用
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        int temp = 0;               // 临时变量
        boolean flag = false;       // 标识变量，表示是否进行过交换，
        for (int i = 0; i < arr.length - 1; i++) {              //控制比较轮数，
            for (int j = 0; j < arr.length - 1 - i; j++) {      //控制比较次数，轮数多一轮，需要比的次数少一个
                if (arr[j] > arr[j + 1]) {
                    flag = true;    //证明交换过
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {            // 在一趟排序中，一次交换都没有发生过，可提前退出
                break;
            } else {
                flag = false;       // 重置flag!!!, 进行下次判断
            }
        }
    }

}

