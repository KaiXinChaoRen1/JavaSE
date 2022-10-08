package s01_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<>();
        for (int i = 0; i <5000000 ; i++) {
            al.add(i);
        }
        long start1 = System.currentTimeMillis();
        //al.remove(4000000);
        al.add(10,404);
        long end1 = System.currentTimeMillis();
        System.out.println("Arraylist增删时间"+(end1-start1));

        System.out.println("-----------------------------");

        LinkedList<Integer> ll=new LinkedList<>();
        for (int i = 0; i <5000000 ; i++) {
            ll.add(i);
        }
        long start2 = System.currentTimeMillis();
        //ll.remove(4000000);
        ll.add(10,404);
        long end2 = System.currentTimeMillis();
        System.out.println("Linkedlist增删时间"+(end2-start2));

    }


}
