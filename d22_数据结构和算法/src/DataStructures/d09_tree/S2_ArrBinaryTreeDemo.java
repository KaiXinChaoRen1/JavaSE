package DataStructures.d09_tree;

/**
 * 顺序存储二叉树，堆排序会用
 */
public class S2_ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);//把这个数组当作我们的二叉树
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }

}

//编写一个ArrayBinaryTree, 实现顺序存储二叉树遍历

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {  //带参构造
        this.arr = arr;
    }

    //重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     *顺序存储二叉树的前序遍历
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if((index * 2 + 1) < arr.length) {       //顺序存储二叉树的左子节点的坐标为2*n+1
            preOrder(2 * index + 1 );
        }
        //向右递归遍历
        if((index * 2 + 2) < arr.length) {       //顺序存储二叉树的右子节点的坐标为2*n+1
            preOrder(2 * index + 2);
        }
    }
}
