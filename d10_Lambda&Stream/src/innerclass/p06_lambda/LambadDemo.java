package innerclass.p06_lambda;

/**
 * 格式 ：（形参） -> {代码块}
 * Lambda表达式的使用前提
 * 1. 只能操作接口（匿名内部类可以操作接口，抽象类，具体类）
 * 2. 接口中有且仅有一个抽象方法
 * 3.有参数就写括号里，有返回值就在{}里return
 * 4.匿名内部类 编译后会生成单独的.class字节码文件，
 *  lambda表达式字节码在运行时动态生成.
 */
public class LambadDemo {
    public static void main(String[] args) {
        //lambda方式实现
        useInterMethod((a, b) -> a + b);    //（有很多能省略的地方，背不下来）

        //匿名内部类实现
        useInterMethod(new MyInterface() {
            @Override
            public double method(double a, double b) {
                return a + b;
            }
        });
    }

    //方法（参数为接口的实现类对象）
    public static void useInterMethod(MyInterface myInstance) {
        double result = myInstance.method(12.7, 22.3);
        System.out.println(result);
    }

}

interface MyInterface {
    double method(double a, double b);  //有参有返回值
}
