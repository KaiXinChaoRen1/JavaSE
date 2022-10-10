package 继承;

public class MyTest {
    public static void main(String[] args) {

        Person p=new Person();
        Man m=new Man();
        System.out.println(m.age1);
        System.out.println(m.age2);
        System.out.println(m.age3);

        Person pm=new Man();
        pm.fly();

    }
}
class Person{
    int age1=22;
    int age2=23;

    void fly(){
        System.out.println("我会飞");
    }


}
class Man extends Person{

    int age3=24;
    void fly(){
        System.out.println("我会飞的更高");
    }



}
