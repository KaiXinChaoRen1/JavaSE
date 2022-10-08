package reflect.myreflect4;

import java.lang.reflect.Field;

/**
 * 利用Field对象,获取值或者修改值
 */

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Object get​(Object obj) 返回由该 Field表示的字段在指定对象上的值。
        //method1();
        method2();

    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.获取class对象
        Class clazz = Class.forName("reflect.myreflect4.Student");

        //2.获取成员变量Field的对象
        Field field = clazz.getDeclaredField("money");

        //3.取消一下访问检查
        field.setAccessible(true);

        //4.调用get方法来获取值
        //4.1创建一个对象
        Student student = (Student) clazz.newInstance();
        //4.2获取指定对象的money的值
        Object o = field.get(student);

        //5.打印一下
        System.out.println(o);
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //        void set​(Object obj, Object value)：给某对象的某成员变量赋值为value

        Class clazz = Class.forName("reflect.myreflect4.Student");

        Field field = clazz.getField("name");

        Student student = (Student) clazz.newInstance();  //先创建一个Student对象

        field.set(student,"liwenqiang");                    //给具体对象进行赋值

        System.out.println(student);
    }
}
