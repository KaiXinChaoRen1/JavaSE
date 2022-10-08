package s03_Set;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

//底层是LinkedHashMap
public class LinkedHashSet_Demo {
    public static void main(String[] args) {
        LinkedHashMap lm=new LinkedHashMap();
        LinkedHashSet  ls=new LinkedHashSet();
        ls.add("abc");
        ls.add(1);
        ls.add(2);
        ls.add(1);
        for (Object o:ls){
            System.out.println(o);
        }
    }
}
