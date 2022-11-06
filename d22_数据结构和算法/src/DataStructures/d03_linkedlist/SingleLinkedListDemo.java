package DataStructures.d03_linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "林冲冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);

        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        System.out.println("链表有效长度");
        System.out.println(getLength(singleLinkedList.getHead()));

/*		System.out.println("反转单链表~~");
	    reversetList(singleLinkedList.getHead());
		singleLinkedList.list();*/

        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        reversePrint(singleLinkedList.getHead());

/*		//加入按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero2);

		//显示一把
		singleLinkedList.list();*/

/*		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
		singleLinkedList.update(newHeroNode);

		System.out.println("修改后的链表情况~~");
		singleLinkedList.list();*/

/*
		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();
*/

/*		//测试一下看看是否得到了倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
		System.out.println("res=" + res);*/

    }

    /**
     * 逆序打印单链表，不能用反转单链表的方法，因为会改变链表结构，用栈的方法
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {                    //空链表，不能打印
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();     //创建要给一个栈，将各个节点压入栈
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);                        //将链表的所有节点压入栈
            cur = cur.next;                         //cur后移，这样就可以压入下一个节点
        }
        while (stack.size() > 0) {                   //将栈中的节点进行打印,pop 出栈
            System.out.println(stack.pop());         //stack的特点是先进后出
        }
    }

    /**
     * 将单链表反转
     */
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;       //辅助的指针(变量)
        HeroNode next = null;           // 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;             //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next; //旧链表遍历的节点插入到新链表前头
            reverseHead.next = cur;
            cur = next;                  //再继续遍历旧的链表
        }
        head.next = reverseHead.next;    //将head.next 指向 reverseHead.next , 实现单链表的反转
    }

    /**
     * 查找单链表中的倒数第k个结点 【新浪面试题】
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {                    //判断如果链表为空，返回null
            return null;
        }
        int size = getLength(head);                 //第一个遍历得到链表的长度(节点个数)
        if (index <= 0 || index > size) {           //先做一个index的校验
            return null;
        }
        HeroNode cur = head.next;                    //第一个有效节点开始
        for (int i = 0; i < size - index; i++) {     //后移（size-index）次就是倒数index
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 查询链表长度，参数为头节点
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;             //遍历
        }
        return length;
    }


}


/**
 * 定义SingleLinkedList (单链表)
 */
class SingleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //普通添加节点 1. 找到当前链表的最后节点 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {   		 //到头了
                break;
            }
            temp = temp.next;				//如果不是最后，将temp后移
        }
        temp.next = heroNode;				//将最后这个节点的next 指向 新的节点
    }

    //有序添加节点：根据排名将英雄插入到指定位置，如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;							//辅助指针
        boolean flag = false; 							// flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {					//到头了，break，添加在该节点后
                break;
            }
            if (temp.next.no > heroNode.no) { 		     //位置找对了，break，添加在该节点后
                break;
            } else if (temp.next.no == heroNode.no) {  	 //已经有了，break
                flag = true;							 //说明编号存在
                break;
            }
            temp = temp.next; 							 //这节点各种情况都不符合啊，那就后移
        }
        //判断flag 的值
        if (flag) { 									  //编号存在，给报错信息
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
			//插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {                //判断是否空
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {                     //已经遍历完链表
                break;
            }
            if (temp.no == newHeroNode.no) {        //找到
                flag = true;                        //标志找到
                break;
            }
            temp = temp.next;                       //都不是，下一个
        }
        if (flag) {                                   //根据flag 判断是否找到要修改的节点
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {                                     //没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;               // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) {        //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {       //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;               //temp后移，遍历
        }
        //判断flag
        if (flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    //显示链表（遍历）
    public void list() {
        if (head.next == null) { 		//判断链表是否为空
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;		 //因为头节点，不能动，因此我们需要一个辅助变量来遍历

        while (true) {
            if (temp == null) {			//判断是否遍历完
                break;
            }
            System.out.println(temp);	//输出节点的信息
            temp = temp.next; 			//将temp后移
        }
    }
}






/**
 * 定义HeroNode ， 每个HeroNode 对象就是一个节点
 */
class HeroNode {
    public int no;          //public属性
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}
