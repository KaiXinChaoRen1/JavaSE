package DataStructures.d05_recursion;

public class Queen8 {

    //定义一个max表示共有多少个皇后
    int   max = 8;
    //定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}，下标代表行，内容是列
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;
    public static void main(String[] args) {
        //测试一把 ， 8皇后是否正确
        Queen8 queue8 = new Queen8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
    }


    /**
     * 放置第n行的第n个皇后
     * @param n
     */
    private void check(int n) {
        if(n == max) {                      //n = 8 , 其实8个皇后就既然放好
            myprint();
            return;
        }
        for(int i = 0; i < max; i++) {       //从该行第一列开始，依次放入皇后，并判断是否冲突
            array[n] = i;                    //i代表列（从0开始），向该列放置皇后，把i（列）赋值给array[n]
            if(judge(n)) {                   //判断当放置第n个皇后到i列时，是否冲突
                check(n+1);               //接着放n+1个皇后,即开始递归
            }
            //如果冲突，if语句不进去，就相当于没有if语句，就继续循环
        }
    }


    /**
     *  检测该皇后是否和前面已经摆放的皇后冲突
     * 第一行放第一个，第n行放第n个，不在同一行，只需判断是否同列或者同斜线即可
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for(int i = 0; i < n; i++) {
            //  array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //  Math.abs(n-i)：行数差
            //  Math.abs(array[n] - array[i])：列数差，相等说明在同一斜线
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * 写一个方法，可以将皇后摆放的位置输出
     */
    private void myprint() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
