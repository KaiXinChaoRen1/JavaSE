package s01_List;


import org.junit.jupiter.api.Test;

import java.util.*;


public class ArrayListDemo {
    /**
     * forEach
     */
    @Test
    public void hehe3() {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");

        myList.forEach(o -> System.out.println(o));
        System.out.println("-------------------------");

        myList.stream().forEach(o -> System.out.println(o));
        System.out.println("在网上看这两种方式差不多-------------------------");


        //---------------------------------------------
        myList.forEach(o->{
            if(o.equals("bbb")){
                myList.remove(o);           //不能直接调用集合本身的remove和add
                myList.add("hehe");
            }
        });
        myList.stream().forEach(o -> {
            myList.add("hehe");
        });
        //-------------------------------------------------

    }


    /**
     * clone(),属于浅拷贝
     */
    @Test
    public void hehe2() {
        People p1 = new People("李逵", 35);
        People p2 = new People("张飞", 35);
        ArrayList<People> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        //clone
        Object cloneList = l.clone();

        System.out.println(l);
        System.out.println(cloneList);

        p1.setName("李鬼");
        p2.setName("张飞机");

        System.out.println(l);
        System.out.println(cloneList);


    }

    /**
     * remove()
     */
    @Test
    public void hehe1() {
        People p1 = new People("李逵", 35);
        People p2 = new People("张飞", 35);
        People p3 = new People("八戒", 35);
        ArrayList<People> peopleList = new ArrayList<>();
        peopleList.add(p1);
        peopleList.add(p2);
        peopleList.add(p3);
        peopleList.remove(0);
        System.out.println(peopleList);//按照索引删除

        People p22 = new People("张飞", 35);
        peopleList.remove(p22);
        System.out.println(peopleList);//重写equals和hashcode之后可以,否则不行

        peopleList.remove(p2);
        System.out.println(peopleList);//删除指定对象

    }
}

