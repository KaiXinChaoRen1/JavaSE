package s01_List;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayList_KuoRong {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        Integer capacity = getCapacity(list1);// 获取容量
        int size = list1.size();
        System.out.println("list1刚创建时的容量:" + capacity);
        System.out.println("list1的大小:" + size);
        System.out.println("----------------------------");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        capacity = getCapacity(list2);// 获取容量,arraylist初始化容量是10
        size = list2.size();
        System.out.println("list2第一次添加的容量:" + capacity);
        System.out.println("list2的大小:" + size);
        System.out.println("----------------------------");

        ArrayList<Integer> list3 = new ArrayList<Integer>();

        capacity = getCapacity(list3);// 获取容量,arraylist初始化容量是10
        for (int i = 0; i < 10; i++) {
            list3.add(i);
        }
        capacity = getCapacity(list3);
        size = list3.size();
        System.out.println("list3的容量:" + capacity);
        System.out.println("list3的大小:" + size);
        System.out.println("----------------------------");

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            list4.add(i);
        }
        capacity = getCapacity(list4);// 获取容量
        size = list4.size();
        System.out.println("list4的容量:" + capacity);
        System.out.println("list4的大小:" + size);

        System.out.println("-------------如果扩1.5不够，那就扩容到刚够----------");

        ArrayList<Integer> list5 = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            list5.add(i);
        }
        ArrayList<Integer> list6 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list6.add(i);
        }
        list6.addAll(list5);
        capacity = getCapacity(list6);// 获取容量
        size = list6.size();
        System.out.println("list6的容量:" + capacity);
        System.out.println("list6的大小:" + size);


    }

    // 获取list容量
    public static Integer getCapacity(ArrayList list) {
        Class clazz = list.getClass();         //获取class对象

        try {

            Field field = clazz.getDeclaredField("elementData");    //获取成员变量
            field.setAccessible(true);                              //取消访问检查
            Object[] object = (Object[]) field.get(list);           //获取指定对象的elementData值
            return object.length;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
