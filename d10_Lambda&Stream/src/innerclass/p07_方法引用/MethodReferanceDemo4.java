package innerclass.p07_方法引用;

/**
 * 4.重写方法的方法体中只有一行代码,且这行代码是调用了某个类的构造方法,同时所有参数按照顺序传入,此时可以考虑方法引用
 */
public class MethodReferanceDemo4 {
    public static void main(String[] args) {
        //匿名内部类
        useInterMethod(new MyInterface() {
            @Override
            public StringBuilder method(String a) {
                return new StringBuilder(a);
            }
        },"aa");
        //lambda
        useInterMethod(a -> new StringBuilder(a),"aa");
        //方法引用
        useInterMethod(StringBuilder::new,"aa");
    }

    // 主方法要调用的方法（参数为接口的实现类对象）
    public static void useInterMethod(MyInterface myInstance,String s1) {
        StringBuilder res = myInstance.method(s1);
        System.out.println(res.getClass());

    }

    interface MyInterface {
        StringBuilder method(String a);
    }

}
