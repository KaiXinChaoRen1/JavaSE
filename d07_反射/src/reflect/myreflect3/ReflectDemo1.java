package reflect.myreflect3;

import java.lang.reflect.Constructor;

/**
 * 获取Constructor对象（四种）
 */

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        method1();
        //method2();
        //method3();
        //method4();


    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("reflect.myreflect3.Student");
        //Class<Student> clazz = Student.class;
        Constructor constructor = clazz.getDeclaredConstructor(String.class);        //返回单个(public+private)构造方法对象
        System.out.println(constructor);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("reflect.myreflect3.Student");

        Constructor constructor1 = clazz.getConstructor();      //返回单个公共public构造方法对象,一定要跟构造方法的形参保持一致.
        System.out.println(constructor1);

        Constructor constructor2 = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor2);
    }

    private static void method2() throws ClassNotFoundException {
        Class clazz = Class.forName("reflect.myreflect3.Student");

        Constructor[] constructors = clazz.getDeclaredConstructors();       //返回所有public+private构造方法对象的数组

        for (Constructor constructor : constructors) {                      //遍历
            System.out.println(constructor);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //Class clazz = Class.forName("reflect.myreflect3.Student"); //获取class对象（字节码对象）
        Class<Student> clazz = Student.class;
        Constructor[] constructors = clazz.getConstructors();       //返回所有公共public构造方法对象的数组

        for (Constructor constructor : constructors) {              //遍历数组
            System.out.println(constructor);
        }
    }
}
