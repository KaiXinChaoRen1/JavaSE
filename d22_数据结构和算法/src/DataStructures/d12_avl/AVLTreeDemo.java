package DataStructures.d12_avl;

public class AVLTreeDemo {

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8};
        //int[] arr = { 10, 12, 8, 9, 7, 6 };
        int[] arr = {10, 11, 7, 6, 8, 9};
        //创建一个 AVLTree对象
        AVLTree avlTree = new AVLTree();
        //添加结点
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8



    }

}

/**
 * AVLTree
 */
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    // 查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 查找父结点
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
    public int delRightTreeMin (Node node) {
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

    // 添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

/**
 * Node结点
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
    // 返回 以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
    // 返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    // 返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }


    /**
     *左旋转方法（重点 ）
     */
    private void leftRotate() {
        //1.创建新的结点，以当前根结点的值
        Node newNode = new Node(value);
        //2.把新结点的左子树，设置成当前结点的左子树
        newNode.left = left;
        //3.把新结点的右子树，设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //4.把当前结点的值用右子结点的值覆盖
        value = right.value;
        //5.把当前结点的右子树设置成当前结点右子树的右子树（原来的right会被垃圾回收）
        right = right.right;
        //6.把当前结点的左子结点设置成我们创建的新结点
        left = newNode;
    }

    /**
     * 右旋转（同理）
     */
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 添加结点，并满足二叉排序树的要求，就是添加完在判断一下用不用旋转，要旋就旋就完啦
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

        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转 ，R型
        if (rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度，RL型
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对右子结点进行右旋转
                right.rightRotate();
                //然后在对当前结点进行左旋转
                leftRotate();
            } else {        //RR型
                //直接进行左旋转即可
                leftRotate();
            }
            return; //（判断完一种情况就return，要不然可能走下面的情况，有危险？存疑）
        }

        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转，L型
        if (leftHeight() - rightHeight() > 1) {
            //如果它的左子树的右子树高度大于它的左子树的左子树的高度，LR型
            if (left != null && left.rightHeight() > left.leftHeight()) {
                //先对当前结点的左结点(左子树)->左旋转
                left.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else {        //LL型
                //直接进行右旋转即可
                rightRotate();
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
