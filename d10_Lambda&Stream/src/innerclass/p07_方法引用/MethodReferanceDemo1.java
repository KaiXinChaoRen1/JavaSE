package innerclass.p07_方法引用;

/**
 * 在lambad写完时发现方法体只有一行代码,且是方法调用时可以尝试使用方法引用
 * 
 * 1.方法体中只有一行代码,且是调用了某个类的静态方法,同时把抽象方法的所有参数按顺序传入这个静态方法时,可以考虑使用方法引用
 */
public class MethodReferanceDemo1 {

    public static void main(String[] args) {
        // 匿名内部类
        useInterMethod(new MyInterface() {
            @Override
            public String method(Float f) {
                return String.valueOf(f);
            }
        }, 12.7f);
        // lambda
        useInterMethod(a -> String.valueOf(a), 12.7f);
        // Method Reference
        useInterMethod(String::valueOf, 12.7f);

    }

    // 主方法要调用的方法（参数为接口的实现类对象）
    public static void useInterMethod(MyInterface myInstance, Float f) {
        // 调用接口的实现方法
        String result = myInstance.method(f);
        System.out.println(result);
    }

    interface MyInterface {     //放在外面需要注意不同命名
        String method(Float f);
    }

}


