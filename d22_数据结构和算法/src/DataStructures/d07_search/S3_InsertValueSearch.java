package DataStructures.d07_search;

/**
 * 插值查找找两头的值快，找中间的不一定，数值分布均匀的快，不均匀不一定
 */
public class S3_InsertValueSearch {
    public static void main(String[] args) {

/*		int [] arr = new int[1000];    //生成0~999数组
		for(int i = 0; i < 1000; i++) {
			arr[i] = i + 1;
		}*/

        int arr[] = { 1, 8, 10, 89,1000,1000, 1111,4444,5555,9999 };

        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        int index2 = binarySearch(arr, 0, arr.length - 1, 1);

        System.out.println("index = " + index);
        System.out.println("index = " + index2);

    }

    /**
     *插值查找算法，也要求数组是有序的
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查找次数~~");
        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须要有，（因为findvalue参与计算mid）
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找，对比用
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("二分查找次数~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}
