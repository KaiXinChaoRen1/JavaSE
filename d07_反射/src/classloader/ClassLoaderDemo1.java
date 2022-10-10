package classloader;

/**
 *  获取三种类加载器
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //陈长宏版类加载器(也是系统类加载器)
        ClassLoader cchclassLoader = ClassLoaderDemo1.class.getClassLoader();

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //获取系统类加载器的父加载器 --- 平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();

        //获取平台类加载器的父加载器 --- 启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println("陈长宏版本类加载器" + cchclassLoader);
        System.out.println("系统类加载器" + systemClassLoader);
        System.out.println("平台类加载器" + classLoader1);
        System.out.println("启动类加载器" + classLoader2);

    }
}
