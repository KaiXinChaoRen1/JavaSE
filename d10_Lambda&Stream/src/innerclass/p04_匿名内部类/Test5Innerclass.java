package innerclass.p04_匿名内部类;

/**
 匿名内部类:（前提: 需要存在类\接口）
 格式:
        new 类名 \ 接口名 (){
        重写方法
        }
 */
public class Test5Innerclass {
    public static void main(String[] args) {

        InterImpl ii = new InterImpl();     //2.接口的实现类创建对象
        ii.show();                          //3.对象调用方法

        //使用匿名内部类一步到位
        new Inter() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类中的show方法");
            }
        }.show();


        //如果多个方法可以用接口对象接收，再调用多个方法
        Inter2 i = new Inter2() {
            @Override
            public void show1() {
                System.out.println("show1...");
            }
            @Override
            public void show2() {
                System.out.println("show2...");
            }
        };
        i.show1();
        i.show2();
    }
}


interface Inter {
    void show();
}

interface Inter2 {
    void show1();
    void show2();
}

class InterImpl implements Inter {      //1.编写接口的实现类
    @Override
    public void show() {
        System.out.println("InterImpl  重写的show方法");
    }
}
