package d01_API.p02_System;

public class SystemDemo {
    public static void main(String[] args) {

        // arraycopy(数据源数组, 起始索引, 目的地数组, 起始索引, 拷贝个数)------数组复制
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[10];
        System.arraycopy(arr1, 2, arr2, 2, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]); // 0123450000
        }

        // 获取系统相关信息(具体再百度)
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.dir"));
    }
}
