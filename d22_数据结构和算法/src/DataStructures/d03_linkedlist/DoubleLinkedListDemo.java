package DataStructures.d03_linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();


    }

}

// 创建一个双向链表的类
class DoubleLinkedList {
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 返回头节点
     * @return
     */
    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;     // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        while (true) {
            if (temp == null) {         // 判断是否到链表最后
                break;
            }
            System.out.println(temp);
            temp = temp.next;            // 将temp后移
        }
    }

    /**
     * 添加一个节点到双向链表的最后.
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;               // 辅助指针 temp
        while (true) {
            if (temp.next == null) {        //到最后了，跳出
                break;
            }
            temp = temp.next;               // 没到最后, 将temp后移
        }
        temp.next = heroNode;               //添加数据，双向链表，双向连上，两行代码
        heroNode.pre = temp;
    }

    /**
     * 修改一个节点的内容
     */
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {                 // 判断是否空
            System.out.println("链表为空~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;                    // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;                           // 到头了，没找到
            }
            if (temp.no == newHeroNode.no) {     // 找到
                flag = true;
                break;
            }
            temp = temp.next;                   //后移
        }
        if (flag) {                             // 根据flag 判断是否找到要修改的节点
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {                                // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 从双向链表中删除一个节点
     */
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;         // 辅助变量(指针)
        boolean flag = false;               // 标志是否找到待删除节点的
        while (true) {
            if (temp == null) {             // 已经到链表的最后
                break;
            }
            if (temp.no == no) {            //找到想要删除的节点
                flag = true;
                break;
            }
            temp = temp.next;               // temp后移，遍历
        }
        if (flag) {                         // 找到
            temp.pre.next = temp.next;
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

}

// 定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}