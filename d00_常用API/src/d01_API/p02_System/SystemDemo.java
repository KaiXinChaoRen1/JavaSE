package d01_API.p02_System;

public class SystemDemo {
    public static void main(String[] args) {
        //一  currentTimeMillis()------获取1970到现在的毫秒值
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("以上代码的执行时间是"+(end - start)+"毫秒");  //一段代码的执行用时



        //二 arraycopy(数据源数组, 起始索引, 目的地数组, 起始索引, 拷贝个数)------数组复制
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = new int[10];
        System.arraycopy(arr1,2,arr2,2,3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]);  //0123450000
        }


        //三exit(0)------停止虚拟机，参数非零表示异常终止
        System.exit(0);
        System.out.println("我还没上车呢。。。");
    }
}
