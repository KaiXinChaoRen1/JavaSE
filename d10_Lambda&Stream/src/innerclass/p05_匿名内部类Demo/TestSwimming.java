package innerclass.p05_匿名内部类Demo;

/**
 * 如果一个方法的参数是接口或者抽象类的话，可以使用匿名内部类作为参数传入
 */
public class TestSwimming {
    public static void main(String[] args) {
        //调用方法，传入匿名内部类的实现做参数
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("铁汁, 我们去游泳吧");
            }
        });
    }

    //方法（参数是接口）
    public static void goSwimming(Swimming sm){
        sm.swim();
    }
}




//接口
interface Swimming {
    void swim();
}
