package reflect.myreflect3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取Constructor对象并创建对象
 */

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //method1();
        method2();
    }

    /**
     *获得私有构造方法并创建对象（需要临时取消访问检查（暴力反射））
     */
    private static void method2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class clazz = Class.forName("reflect.myreflect3.Student");

        //2.获取一个私有化的构造方法.
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //被private修饰的成员,不能直接使用的
        //如果用反射强行获取并使用,需要临时取消访问检查（暴力反射）
        constructor.setAccessible(true);

        //3.直接创建对象
        Student student = (Student) constructor.newInstance("zhangsan");

        System.out.println(student);
    }

    /**
     *获得公有构造方法并创建对象
     */
    private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取class对象
        Class clazz = Class.forName("com.itheima.myreflect3.Student");

        //2.获取构造方法对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        //3.利用newInstance​创建Student的对象
        Student student = (Student) constructor.newInstance("zhangsan", 23);

        System.out.println(student);
    }
}
