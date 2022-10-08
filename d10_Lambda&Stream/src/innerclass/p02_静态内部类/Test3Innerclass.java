package innerclass.p02_静态内部类;

/**
 静态成员内部类演示
 */
public class Test3Innerclass {
    public static void main(String[] args) {
        Outer.Inner oi = new Outer.Inner();     //Inner注意不用new
        oi.show();              //对象调用成员方法
        oi.method();            //对象调用静态方法
        Outer.Inner.method();   //外部类调用静态内部类的静态方法
    }
}

class Outer {
    static class Inner {                //静态内部类
        public void show(){             //静态内部类的方法
            System.out.println("静态内部类的普通方法执行");
        }
        public static void method(){    //静态内部类的静态方法
            System.out.println("静态内部类的静态方法执行");
        }
    }
}