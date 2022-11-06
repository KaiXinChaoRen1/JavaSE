package DataStructures.d07_search;

import java.util.ArrayList;
import java.util.List;

//注意：使用二分查找的前提是 该数组是有序的.
public class S2_BinarySearch {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10, 11, 12, 13, 14, 15, 15, 16, 17, 18, 19, 20};
        int i = binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println(i);

        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 15);
        System.out.println("resIndexList=" + resIndexList);
    }


    /**
     * 二分查找算法
     *
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {             // 当 left > right 时，说明递归整个数组，但是没有找到
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];          //中间值
        if (findVal > midVal) {         //若比中间值大
            return binarySearch(arr, mid + 1, right, findVal);//递归右边
        } else if (findVal < midVal) {  //小
            return binarySearch(arr, left, mid - 1, findVal);//递归左边
        } else {
            return mid;                 //相等返回
        }

    }


    /**
     * 当有多个相同的值时，如何将所有的数值都查找到？
     * 再找到第一个（mid=findval）后，
     * 向mid 索引值的左边扫描，将所有满足条件的元素的下标，加入到集合ArrayList
     * 向mid 索引值的右边扫描，将所有满足条件的元素的下标，加入到集合ArrayList
     * 将Arraylist返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            //向mid 索引值的左边扫描，将所有满足条件的元素的下标，加入到集合ArrayList
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//到头了，或者不相等了，就退出
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp -= 1; //temp左移
            }
            resIndexlist.add(mid);  //
            //向mid 索引值的右边扫描，将所有满足条件的元素的下标，加入到集合ArrayList
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                //否则，就temp 放入到 resIndexlist
                resIndexlist.add(temp);
                temp += 1; //temp右移
            }
            return resIndexlist;
        }

    }
}
