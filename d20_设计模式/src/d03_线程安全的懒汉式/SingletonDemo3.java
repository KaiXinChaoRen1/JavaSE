package d03_线程安全的懒汉式;

/**
 *  线程安全但是顶不住反射，枚举能顶住（会抛出异常）
 *
 *  只是双重校验，
 *  如果没有外部的校验，每个线程都要走一遍同步代码块判断，效率很低
 *  如果没有内部的校验，会有多个线程创建多个实例
 *
 *  volatile目的不是为了单例，而是在后续的使用中，因为单例，要在多线程的情况下，保证可见性。
 */
public class SingletonDemo3 {
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Bank bank2 = Bank.getBank();
        System.out.println(bank==bank2);
    }
}

class Bank{
    private static volatile Bank bank=null;

    private Bank(){ }

    public static Bank getBank(){
        if(bank==null){
            synchronized (Bank.class){
                if (bank==null){
                    bank=new Bank();
                }
            }
        }
        return bank;
    }
}
