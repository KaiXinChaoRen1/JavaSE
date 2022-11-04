package innerclass.p07_方法引用;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
 *  2.方法体中只有一行代码,且是调用了某个对象的成员方法,同时把抽象方法的所有参数按顺序传入这个静态方法时,可以考虑使用方法引用 
 */
public class MethodReferanceDemo2 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");

        // 匿名内部类
        StringBuilder sb1 = new StringBuilder("Hello");
        arrayList.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                sb1.append(t);

            }
        });
        System.out.println(sb1);
        // lambda表达式
        StringBuilder sb2 = new StringBuilder("Hello");
        arrayList.stream().forEach(str -> sb2.append(str));
        System.out.println(sb2);
        // 方法引用
        StringBuilder sb3 = new StringBuilder("Hello");
        arrayList.stream().forEach(sb3::append);
        System.out.println(sb3);
    }

}
