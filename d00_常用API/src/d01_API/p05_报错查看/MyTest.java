package d01_API.p05_报错查看;

public class MyTest {
    public static void main(String[] args) {
        d();
    }
    public static void a(){
        int a=1/0;
    }
    public static void b(){
        a();
    }
    public static void c(){
        b();
    }
    public static void d(){
        c();
    }
}
