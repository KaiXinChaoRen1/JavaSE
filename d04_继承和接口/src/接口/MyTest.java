package 接口;

public class MyTest {
    public static void main(String[] args) {

        System.out.println(Fly.space);  //接口直接访问常量
        Fly.staticFlying();             //接口直接访问静态方法


        Liwenqiang li = new Liwenqiang("李文强", 24);
        li.flying();                    //实现类访问实现方法
        li.xiao();                      //实现类直接访问不用重写的默认方法

    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("人会吃饭");
    }

}

class Liwenqiang extends Person implements Fly {

    public Liwenqiang(String name, int age) {
        super(name, age);
    }

    public void eat() {
        System.out.println("我吃鸡胸肉");
    }

    @Override
    public void flying() {
        System.out.println("接口让我飞我必须飞，速度是" + space);
    }
}

/**
 * 接口
 */
interface Fly {
    int space = 800;      //默认public static final

    void flying();      //默认public abstract

    //下面两个是jdk1.8新增的
    static void staticFlying() {
        System.out.println("接口中的静态方法");
    }

    default void xiao() {
        System.out.println("接口中的默认方法");
    }
}