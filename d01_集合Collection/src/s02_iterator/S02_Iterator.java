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
        ArrayList<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        Iterator<String> iterator = list.iterator();  //创建出迭代器后，迭代器指向索引0处

/*        //迭代器遍历
        while (iterator.hasNext()){               //当前索引有无元素
            System.out.println(iterator.next());    //输出当前并后移
        }*/

/*        //常规方法删除多个元素
        for (int i = 0; i < list.size(); i++) {
            if("b".equals(list.get(i))){
                list.remove(i);
                i--;                    //因为集合删除后，后面的会往前补全，所以很费事
            }
        }*/
        while (iterator.hasNext()){          //要先把前面的用迭代器遍历代码注释掉，因为前边遍历一遍 已经指向最后了
            String s =iterator.next();
            if ("b".equals(s)){
                iterator.remove();
            }
        }

        System.out.println(list);


    }
}
