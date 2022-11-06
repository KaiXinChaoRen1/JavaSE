package DataStructures.d06_sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序，空间换时间
 */
public class S7_RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214, 369, 69, 9};
        radixSort(arr);
        System.out.println("基数排序后 " + Arrays.toString(arr));

       /* // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G,内存超了
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        */

    }

    /**
     * 基数排序
     * 空间换时间
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，10个桶, 每个桶就是一个一维数组，防止数据溢出，大小定为arr.length
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //下标代表捅号，数据代表桶内数据数量
        //比如：counts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] counts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中，比如：counts[0] , 记录的就是  bucket[0] 桶的放入数据个数
                bucket[digitOfElement][counts[digitOfElement]] = arr[j];
                counts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组，
//            for(int k = 0; k < counts.length; k++) {
            for (int k = 0; k < 10; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (counts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < counts[k]; l++) {
                        //取出元素（第k个桶，第L个元素）放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                counts[k] = 0;

            }
            //System.out.println("第" + (i + 1) + "轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
    }
}
