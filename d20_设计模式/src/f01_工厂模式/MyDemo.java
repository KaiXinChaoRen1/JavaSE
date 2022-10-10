package f01_工厂模式;

public class MyDemo {
    public static void main(String[] args) {
        LenovoFactory factory=new LenovoFactory();
        factory.getLenovoGoods(100).gongneng();
        factory.getLenovoGoods(200).gongneng();
    }
}

class LenovoFactory{
    public Lenovo getLenovoGoods(Integer type){
        if(type==null) return null;
        if(type.equals(100)) return new LenovoJianpan();
        else if (type.equals(200)) return new LenovoShubiao();
        else return null;
    }
}

interface Lenovo{
    void gongneng();
}

class LenovoShubiao implements Lenovo{

    @Override
    public void gongneng() {
        System.out.println("有了它就成为鼠标侠");
    }
}
class LenovoJianpan implements Lenovo{

    @Override
    public void gongneng() {
        System.out.println("有了它就成为键盘侠");
    }
}
