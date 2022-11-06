package Algorithm.d05_greedy;

import java.util.*;

public class Ceshi {
    public static void main(String[] args) {
        Set myset=new HashSet<String>();
        myset.add("上海");
        myset.add("北京");
        myset.add("上海");
        myset.add("广州");
        myset.add("深圳");
        myset.add("深圳");
        Set yourset=new HashSet<String>();
        yourset.add("上海");
        yourset.add("杭州");
        yourset.add("火星");
        System.out.println("输出myset"+myset);
        //myset.retainAll(yourset);
        System.out.println("输出yourset"+yourset);
        //System.out.println("输出myset调用retainAll（yourset）后"+myset);
/*
        myset.addAll(yourset);
        System.out.println(myset);
*/
/*        myset.removeAll(yourset);
        System.out.println("myset.removeAll(yourset)之后的myset"+myset);*/
        myset.clear();
        System.out.println(myset);



/*        List<String> mylist=new ArrayList<String>();
        mylist.add("北京");
        mylist.add("上海");
        mylist.add("上海");
        mylist.add("上海");
        System.out.println(mylist);
        Map mymap=new HashMap<String,String>();
        mymap.put("i","我");
        mymap.put("u","你");
        System.out.println(mymap);
        System.out.println(mymap.keySet());*/


    }
}
