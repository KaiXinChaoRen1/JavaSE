package innerclass.p03_局部内部类;

/**
 局部内部类:
 编写位置: 方法中
 访问方式: 只能在方法中, 创建对象并访问
 （很少使用，匿名内部类的前置知识）
 */
public class Test4Innerclass {

    public static void main(String[] args) {
        Outer o = new Outer();
        o.method();
    }
}

class Outer {
    int a = 10;

    public void method(){
        int b = 20;

        class Inner {           //局部内部类的声明
            public void show(){
                System.out.println("show...");
                System.out.println(a);
                System.out.println(b);
            }
        }
        Inner i = new Inner();  //局部内部类创建对象
        i.show();               //调用方法

    }

}
