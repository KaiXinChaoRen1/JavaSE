package e01_模板方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyDemo {
    public static void main(String[] args) {
        Hehe h=new Hehe();
        h.spendTime();
    }
}

abstract class Template {
    public void spendTime() {

        long start = System.currentTimeMillis();
        //不固定的内容
        code();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public abstract void code();
}
class Hehe extends Template{

    @Override
    public void code() {
        List<Integer> l=new ArrayList<>();
        for (int i = 0; i <5000000 ; i++) {
            l.add(i);
        }
    }
}
