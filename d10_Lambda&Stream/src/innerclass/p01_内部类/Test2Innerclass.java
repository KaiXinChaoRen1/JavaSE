package innerclass.p01_内部类;

/**
    内部类 和 私有成员内部类 演示
 */
public class Test2Innerclass {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();   //非私有的内部类可以直接创建
        oi.show();

        Outer2 o2 = new Outer2();       //私有内部类可以通过公有方法创建并调用方法
        o2.method();
    }
}


class Outer {
    private int o=18;           //外部类的成员变量内部类可以访问

    /**
     * 内部类
     */
    class Inner {
        private int i=21;       //内部类的成员变量
        public void show(){     //内部类的成员方法

            System.out.println("外部类的成员变量："+0);
        }
    }

}


class Outer2 {
    /**
     * 私有内部类
     */
    private class Inner {       //1.内部类为私有时，不能直接调用
        public void show(){

            System.out.println("私有内部类方法执行。。");
        }
    }

    public void method(){       //2.需要用公有的方法调用
        Inner i = new Inner();
        i.show();
    }
}