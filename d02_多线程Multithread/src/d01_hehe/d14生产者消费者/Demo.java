package d01_hehe.d14生产者消费者;

public class Demo {
    public static void main(String[] args) {

        Foodie f = new Foodie();
        Cooker c = new Cooker();

        f.start();
        c.start();

    }
}
