package s04_Map;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> myTreeMap =new TreeMap<>();

        myTreeMap.put(12,"十二");
        myTreeMap.put(1,"一");
        myTreeMap.put(5,"五");
        myTreeMap.put(4,"四");
        myTreeMap.put(1,"壹");

        for(Integer i: myTreeMap.keySet()){
            System.out.println(myTreeMap.get(i));
        }



    }
}
