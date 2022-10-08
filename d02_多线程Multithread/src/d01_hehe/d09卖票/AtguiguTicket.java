package d01_hehe.d09卖票;
//资源类
class Tickets{
    private int nums=30;

    public synchronized void sale(){
        if(nums>0){
            nums--;
            System.out.println(Thread.currentThread().getName()+"卖了一张还剩"+nums+"张");
        }
    }
}

public class AtguiguTicket {
    public static void main(String[] args) {
        Tickets tickets=new Tickets();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    tickets.sale();
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 300; i++) {
                    tickets.sale();
                }
            }
        },"BB").start();
    }
}
