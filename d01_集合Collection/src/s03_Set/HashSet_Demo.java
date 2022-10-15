package s03_Set;


import java.util.*;

/**
 * 1.不重复（null值可以有一个）
 * 2.存取顺序不一致
 * （3.无操作索引方法）
 */

public class HashSet_Demo {
    public static void main(String[] args) {
        HashSet<String> mySet =new HashSet<>();
        mySet.add("aa");
        mySet.add("bbb");
        mySet.add("cccc");
        mySet.add("dddddd");
        mySet.add("eeeeeee");
        mySet.add("eeeeeee");
        System.out.println("直接打印Set==>"+mySet);

        System.out.println("查看Set中是否包含a==>"+mySet.contains("aa"));

        System.out.println("-------------------增强for");
        for(String s :mySet){
            System.out.println(s);
        }
        System.out.println("---------------------迭代器");
        Iterator<String> mySetIterator = mySet.iterator();
        while (mySetIterator.hasNext()){
            System.out.println(mySetIterator.next());
        }
        System.out.println("-----------此时迭代器已经指向最后,下次再用迭代器可以重新创建一个---------------");
        while (mySetIterator.hasNext()){
            System.out.println(mySetIterator.next());
        }
        System.out.println("-----------此时迭代器已经指向最后,下次再用迭代器可以重新创建一个---------------");
        Iterator<String> iterator = mySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("--------------构造一个包含指定集合中的元素的新集合-----------");
        ArrayList<String> hehe = new ArrayList<>();
        hehe.add("帅强");
        hehe.add("shit春");
        hehe.add("伦子");

        HashSet<Object> mySet2 = new HashSet<>(hehe);
        System.out.println(mySet2);


    }
}