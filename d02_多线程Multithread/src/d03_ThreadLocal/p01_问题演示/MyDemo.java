package d03_ThreadLocal.p01_问题演示;

class MySource{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class MyDemo {
    public static void main(String[] args) {
        MySource mySource=new MySource();

        for (int i = 0; i <500 ; i++) {   //创建五个线程
            new Thread(()->{
                mySource.setValue(Thread.currentThread().getName()+"的数据");
                System.out.println(Thread.currentThread().getName() + "---->" + mySource.getValue());
            },"线程"+i).start();
        }

    }
}
