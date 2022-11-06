package Algorithm.d01_binarysearchnorecur;

/**
 * 二分查找非递归
 */
public class BinarySearch {
    public static void main(String[] args) {
        //测试
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 1);
        System.out.println("index=" + index);
    }


    /**
     * 二分查找的非递归方法
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {           //说明继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;        //需要向左边查找
            } else {
                left = mid + 1;         //需要向右边查找
            }
        }
        return -1;
    }
}
