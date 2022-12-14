package DataStructures.d08_hashtab;

import java.util.Scanner;

/**
 * 哈希表（散列表）数组与链表结合
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}

/**
 * 创建HashTab类 管理多条链表
 */
class  HashTab {
    private EmpLinkedList[] empLinkedListArray;

    private int size;               //表示有多少条链表

    public int hashFun(int id) {    //编写散列函数
        return id % size;
    }

    //构造器
    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];       //创建数组
        for(int i = 0; i < size; i++) {                     //给数组每格，创建链表
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id和散列函数，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表,遍历hashtab
    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入的id,查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (empLinkedListNO + 1), id);
        }else{
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

}


/**
 * 雇员类
 */
class Emp {
    public int id;
    public String name;
    public Emp next; //next 默认为 null
    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

/**
 * 创建EmpLinkedList类,表示链表
 */
class EmpLinkedList {
    //链表的head 是直接指向第一个Emp
    private Emp head; //默认null

    //添加雇员到链表
    public void add(Emp emp) {
        if(head == null) {      //如果是添加第一个雇员
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while(true) {
            if(curEmp.next == null) {//说明到链表最后
                break;
            }
            curEmp = curEmp.next; //后移
        }
        curEmp.next = emp;      //退出时直接将emp 加入链表
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if(head == null) {
            System.out.println("第 "+no+" 链表为空");
            return;
        }
        System.out.print("第 "+no+" 链表的信息为");
        Emp curEmp = head;      //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp findEmpById(int id) {
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;       //辅助指针
        while(true) {
            if(curEmp.id == id) {//找到
                break;//这时curEmp就指向要查找的雇员
            }
            //退出
            if(curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//以后
        }
        return curEmp;
    }

}

