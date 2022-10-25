package d01_API.p01_Math;

/**
 * 构造方法私有，来保证不能创建对象
 */
public class MathDemo {

    public static void main(String[] args) {

        System.out.println(Math.abs(-10)); // 绝对值

        System.out.println(Math.ceil(10.1)); // 向上取整

        System.out.println(Math.floor(10.9)); // 向下取整

        System.out.println(Math.round(10.4)); // 四舍五入

        System.out.println(Math.max(10, 20));

        System.out.println(Math.min(10, 20));

        System.out.println(Math.pow(2, 3)); // 次方

        System.out.println(Math.random()); // 返回值为double的正值，[0.0,1.0)

    }
}
