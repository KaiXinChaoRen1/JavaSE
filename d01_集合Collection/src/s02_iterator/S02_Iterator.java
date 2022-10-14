package s02_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 只有实现Iterator接口的类才可以使用迭代器和增强for
 * 单列集合Collection可
 * 双列集合Map不可
 */
public class S02_Iterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");

        //迭代器遍历(把next当成current就行,就是判断当前)
//        while (iterator.hasNext()){               //当前索引有无元素
//            System.out.println(iterator.next());    //输出当前并后移
//        }

        //for循环中不能直接remove和add
//        for (String s : list) {
//            if ("b".equals(s)) {
//                list.remove(s);
//            }
//        }
//        for (String s : list) {
//            if ("b".equals(s)) {
//                list.add("z");
//            }
//        }

//        while (iterator.hasNext()){        //要先把前面的用迭代器遍历代码注释掉，因为前边遍历一遍 已经指向最后了
//            String s =iterator.next();
//            if ("b".equals(s)){
//                iterator.remove();
//            }
//        }

        //上面五行加上创建迭代器的一行代码可以转化为下面两行,连第一行注释都是idea自动转换的
        //创建出迭代器后，迭代器指向索引0处
        list.removeIf("b"::equals);


        System.out.println(list);


    }
}
