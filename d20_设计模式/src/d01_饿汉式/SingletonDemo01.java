package d01_饿汉式;

/**
 * 单例模式 饿汉式  线程安全但是浪费资源
 */
public class SingletonDemo01 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getBank();
        Bank bank2 = Bank.getBank();
        System.out.println(bank1==bank2);

    }
}
class Bank{
    //静态私有的成员变量
    private static Bank bank=new Bank();

    //私有构造
    private Bank(){ }

    //共有方法 返回静态成员
    public static Bank getBank(){
        return bank;
    }
}
