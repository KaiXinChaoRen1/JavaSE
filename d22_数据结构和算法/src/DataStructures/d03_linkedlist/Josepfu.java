package DataStructures.d03_linkedlist;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试一把看看构建环形链表，和遍历是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }

}

/**
 * 环形的单向链表
 */
class CircleSingleLinkedList {

    private Boy first = null;                   //头指针

    /**
     * 创建nums个节点的链表
     */
    public void addBoy(int nums) {
        if (nums < 1) {                         // nums 做一个数据校验
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;                       // 辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {        // 使用for来创建我们的环形链表
            Boy boy = new Boy(i);                // 创建小孩节点
            if (i == 1) {                        // 如果是第一个小孩
                first = boy;
                first.setNext(first);            // 构成环
                curBoy = first;                  // 让curBoy指向第一个小孩
            } else {                             //除了第一个节点
                curBoy.setNext(boy);             //连上
                boy.setNext(first);              //环上
                curBoy = boy;                    //后移
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        if (first == null) {                             // 判断链表是否为空
            System.out.println("没有任何小孩~~");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo()); //输出
            if (curBoy.getNext() == first) {                      // 说明遍历完了
                break;
            }
            curBoy = curBoy.getNext();                    // curBoy后移
        }
    }

    /**
     *根据用户的输入，计算出小孩出圈的顺序
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {     //first是头指针，前边创建了
        if (first == null || startNo < 1 || startNo > nums) {       // 先对数据进行校验
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        Boy helper = first;                                      // 辅助指针，
        while (true) {                                           //这个循环目的是辅助指针指向环形链表最后一个节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        for(int j = 0; j < startNo - 1; j++) {                   //第几个小孩开始数，先得找到那个小孩
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true) {                                            //报数时让first 和 helper 指针都移动 countNum-1 次, 然后出圈
            if(helper == first) {                                //到最后一个了
                break;
            }
            for(int j = 0; j < countNum - 1; j++) {              //让 first 和 helper 指针同时 的移动 countNum - 1
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());    //这时first指向的节点，就是要出圈的小孩节点
            first = first.getNext();                            //first后移
            helper.setNext(first);                              //已出圈的老表的前一个，连上已出圈的后一个
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

/**
 * 创建一个Boy类，表示一个节点
 */
class Boy {
    private int no;// 编号         private属性
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}
