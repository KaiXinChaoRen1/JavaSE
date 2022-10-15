package s03_Set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 和红黑树相比，AVL树是严格的平衡二叉树，平衡条件必须满足（所有节点的左右子树高度差的绝对值不超过1）。
 * 不管我们是执行插入还是删除操作，只要不满足上面的条件，就要通过旋转来保持平衡，
 * 而旋转是非常耗时的，由此我AVL树适合用于插入与删除次数比较少，但查找多的情况
 *
 * 底层时TreeMap
 * TreeSet可对存储的数据进行排序
 *      自然排序：自定义类实现'Comparable<自定义类>'接口，并在其中复写方法
 *      比较器排序：创建TreeSet使用带参构造，传入匿名内部类做参数
 */
public class TreeSet_Demo {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        Student s1 = new Student("zhangsan", 8);
        Student s2 = new Student("lisi", 8);
        Student s3 = new Student("lwq", 18);
        Student s4 = new Student("sb", 28);
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        System.out.println(treeSet);


        System.out.println("-------------------------------------");


        TreeSet<String> myset = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();             //按照长度比较
                result = result == 0 ? o1.compareTo(o2) : result;   //长度一样则按照自然排序比较
                return result;
            }
        });
        myset.add("c");
        myset.add("abcd");
        myset.add("aaaa");
        myset.add("bcde");
        myset.add("bcdef");
        System.out.println(myset);




    }
}
