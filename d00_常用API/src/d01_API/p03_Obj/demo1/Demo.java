package d01_API.p03_Obj.demo1;

public class Demo {
    public static void main(String[] args) {
        Student s = new Student("张三",23);
        Student s2 = new Student("张三",23);

        System.out.println(s);

        System.out.println(s.toString());

        System.out.println(s==s2);

        System.out.println(s.equals(s2));

    }
}
