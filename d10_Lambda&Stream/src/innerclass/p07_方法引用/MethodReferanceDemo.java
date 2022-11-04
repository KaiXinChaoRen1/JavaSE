package innerclass.p07_方法引用;

/**
 * 在lambad写完时发现方法体只有一行代码,且是方法调用时可以尝试使用方法引用
 * 
 * 1.方法体中只有一行代码,且是调用了某个类的静态方法,同时把抽象方法的所有参数按顺序传入这个静态方法时,可以使用方法引用
 */
public class MethodReferanceDemo {
    
    public static void main(String[] args) {
        //lambda
        useInterMethod(a  -> String.valueOf(a));
        //Method Reference
        useInterMethod(String::valueOf);

    }
    //方法（参数为接口的实现类对象）
    public static void useInterMethod(MyInterface myInstance) {
        String result = myInstance.method(12.7F);
        System.out.println(result);
    }

}
interface MyInterface {
    String method(Float f); 
}
