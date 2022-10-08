package d04_枚举实现单例;

public class SingletonDemo {
    public static void main(String[] args) {
        Bank money = Bank.MONEY;
        Bank money2 = Bank.MONEY;
        System.out.println(money==money2);

    }
}

enum Bank{
    MONEY();
}
