package d01_API.p04_BigDecimal;

import java.math.BigDecimal;

public class MyBigDecimalDemo {
    public static void main(String[] args) {
        System.out.println("浮点数直接计算不够精确");
        System.out.println(10.0 / 3.0);          //不够精确
        System.out.println(0.1+0.2);             //不够精确
        System.out.println("-----------------------------------------");

        BigDecimal bd1 = new BigDecimal("0.1"); //字符串的构造比直接传数字更精确
        BigDecimal bd2 = new BigDecimal("0.2");

        System.out.println("和为" + bd1.add(bd2));

        System.out.println("差为" + bd1.subtract(bd2));

        System.out.println("积为" + bd1.multiply(bd2));

        System.out.println("商为"+bd1.divide(bd2));

        System.out.println("-----------------------------------------------------");
        BigDecimal bd3 = new BigDecimal("10");
        BigDecimal bd4 = new BigDecimal("3");

        //System.out.println(bd3.divide(bd4));    //无限不循环不能精确，所以会报错

        BigDecimal divide = bd3.divide(bd4, 2, BigDecimal.ROUND_HALF_UP); //45
        BigDecimal divide2 = bd3.divide(bd4, 2, BigDecimal.ROUND_UP);     //进一
        BigDecimal divide3 = bd3.divide(bd4, 2, BigDecimal.ROUND_FLOOR);  //去尾
        System.out.println(divide);
        System.out.println(divide2);
        System.out.println(divide3);



    }
}
