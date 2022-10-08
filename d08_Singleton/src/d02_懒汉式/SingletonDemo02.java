package d02_懒汉式;
/**
 * 懒汉式
 * 线程不安全
 */
public class SingletonDemo02 {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Bank bank2 = Bank.getBank();
        System.out.println(bank==bank2);
    }
}

class Bank{
    //静态私有的成员变量
    private static Bank bank=null;

    //私有构造
    private Bank(){ }

    //共有方法 返回静态成员
    public static Bank getBank(){
        if (bank==null){
            bank=new Bank();
        }
        return bank;
    }
}

