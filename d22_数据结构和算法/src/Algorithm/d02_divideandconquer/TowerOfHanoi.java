package Algorithm.d02_divideandconquer;

public class TowerOfHanoi {

    public static void main(String[] args) {
        move(2, 'A', 'B', 'C');
        System.out.println(5/2);

    }


    /**
     * 汉诺塔移动（分治算法）
     * @param num   盘子数目
     * @param a     柱子a
     * @param b     柱子b
     * @param c     柱子c
     */
    public static void move(int num, char a, char b, char c) {
        //如果只有一个盘
        if(num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);        //具体的移动操作使用输出语句代表
        }
        //如果有多个盘
        else {
            //我们可以把多个盘看成两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c，注意abc的顺序
            move(num - 1, a, c, b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            move(num - 1, b, a, c);
        }
    }

}
