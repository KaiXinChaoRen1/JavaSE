package innerclass.p07_方法引用;

/**
 * 3.重写方法的方法体中只有一行代码,且这行代码是调用了第一个参数的的成员方法,同时将剩余的参数按照顺序传入,此时可以考虑方法引用
 */
public class MethodReferanceDemo3 {
    public static void main(String[] args) {
        //匿名内部类
        useInterMethod("狂风绝息斩", new MyInterface() {
            @Override
            public String method(String str, int start, int end) {
               return str.substring(start,end);
            }
        });
        //lambda
        useInterMethod("狂风绝息斩",(str,start,end)->str.substring(start,end));
        //Method Referance
        useInterMethod("狂风绝息斩",String::substring);
    }
    // 主方法要调用的方法（参数为接口的实现类对象）
    public static void useInterMethod(String s,MyInterface myInstance) {
        int start=0;
        int end=2;
        String res = myInstance.method(s, start, end);
        System.out.println(res);

    }

    interface MyInterface {
        String method(String str,int start,int end);
    }
    
}


