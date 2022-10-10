package reflect.myreflect4;

import java.lang.reflect.Field;

/**
 * 获取Field对象(成员变量)
 */

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //method1();
//        method2();
//        method3();
        method4();


    }

    private static void method4() throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("reflect.myreflect4.Student");

        Field field = clazz.getDeclaredField("money");      //返回单个成员变量对象

        System.out.println(field);
    }

    private static void method3() throws ClassNotFoundException, NoSuchFieldException {

        Class clazz = Class.forName("reflect.myreflect4.Student");

        Field field = clazz.getField("gender");      //Field getField​(String name)：返回单个公共成员变量对象

        System.out.println(field);
    }

    private static void method2() throws ClassNotFoundException {

        Class clazz = Class.forName("reflect.myreflect4.Student");

        Field[] fields = clazz.getDeclaredFields();         //返回所有成员变量对象的数组

        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void method1() throws ClassNotFoundException {

        Class clazz = Class.forName("reflect.myreflect4.Student");    //1.获取class对象

        Field[] fields = clazz.getFields();         //2.返回所有公共成员变量对象的数组

        for (Field field : fields) {                //3.遍历
            System.out.println(field);
        }
    }
}
