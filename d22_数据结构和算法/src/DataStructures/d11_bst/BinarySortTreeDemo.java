package DataStructures.d11_bst;

public class BinarySortTreeDemo {

    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历原二叉排序树~");
        binarySortTree.infixOrder();



        //测试一下删除叶子结点
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(7);

        System.out.println("看看我们删除完事后");
        binarySortTree.infixOrder();


    }

}

/**
 * 二叉排序树
 */
class BinarySortTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


    /**
     * 返回的并删除 以node 为根结点的二叉排序树的最小结点的值
     * @param node
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {       //循环的查找左子节点，就会找到最小值
            target = target.left;
        }                           //出循环时 target就指向了最小结点
        delNode(target.value);      //删除最小结点
        return target.value;        //target.value对应的那个node在树中被删除了，但是target.value还在
    }


    /**
     * 删除结点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) {
            System.out.println("这是一棵空树");
            return;
        } else {
            Node targetNode = search(value);        //先去找到要删除的结点  targetNode
            if (targetNode == null) {
                System.out.println("树中没有要删除的节点");
                return;
            }
            if (root.left == null && root.right == null) {      //走到这一步就说明找到了要删除的节点,进判断发现这棵树只有一个节点，那说明根节点就是想删除的节点
                root = null;                                    //删除即可
                return;
            }
            //找到targetNode的父结点
            Node parent = searchParent(value);
            //情况1：如果targetNode是叶子结点（零棵子树）
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.value == value) {            //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {   //是右子结点
                    parent.right = null;
                }
            }
            //情况2：删除有两颗子树的节点（情况2，3不要颠倒，因为一棵子树的判断条件包括两颗）
            else if (targetNode.left != null && targetNode.right != null) {
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }
            //情况3：删除只有一颗子树的结点
            else {
                //情况3.1：要删除的结点有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {                           //情况n：如果删的不是根节点是普通节点，
                        //情况3.1.1：如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        }
                        //情况3.1.2：如果targetNode 是 parent 的右子结点
                        else {
                            parent.right = targetNode.left;
                        }
                    } else {                                        //如果要删的是根节点，那么root = targetNode.left;就完啦
                        root = targetNode.left;
                    }
                }
                //情况3.2要删除的结点有右子结点
                else {
                    if (parent != null) {
                        //情况3.2.1：如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        }
                        //情况3.2.2：如果 targetNode 是 parent 的右子结点
                        else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }

        }
    }

    /**
     * 添加结点的方法
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

/**
 * 二叉排序树的Node结点
 */
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    /**
     * 添加结点的方法
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {       //如果新结点比我们这个原节点小
            if (this.left == null) {             //如果我们这个节点没有左子节点
                this.left = node;               //就把新节点挂到该节点的左子节点
            } else {                            //如果我们这个节点有左子节点，就递归判断其左子节点
                this.left.add(node);
            }
        } else {                              //如果新结点比我们这个原节点大
            if (this.right == null) {            //同理判断右子节点
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 查找要删除的结点
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) { //找到就是该结点
            return this;
        } else if (value < this.value) {    //如果查找的值小于当前结点，向左子树递归查找
            if (this.left == null) {        //如果左子结点为空,说明树里没有这个节点
                return null;
            }
            return this.left.search(value); //不为空就继续找
        } else {                            //如果查找的值大于等于当前结点，向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除结点的父结点
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        //当前节点不是要找的节点的父节点
        else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);       //向左子树递归查找
            }
            //如果查找的值大于当前结点, 并且当前结点的右子结点不为空
            else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);      //向右子树递归查找
            }
            //没有找到父结点
            else {
                return null;
            }
        }

    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}
