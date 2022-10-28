package d02_BPI.p01_Optional;

import java.util.Optional;
/**
 * 1不要将其用作类中的字段，因为它不可序列化
 * 2不要将其用作构造函数和方法的参数，因为这会导致不必要的复杂代码。
 */
public class OptionalDemo {
    public static void main(String[] args) {

        
        //创建1
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());
        //创建2
        Optional<String> stringOptional = Optional.of("name");
        System.out.println(stringOptional.isPresent());
        //Optional<String> stringOptional2 = Optional.of(null);     //传空报错

        //创建3
        Optional<String> stringOptional3 = Optional.ofNullable("hehe");
        Optional<String> stringOptional4 = Optional.ofNullable(null);
        System.out.println(stringOptional3.isPresent());
        System.out.println(stringOptional4.isPresent());

        //ifPresent
        stringOptional3.ifPresent(o->System.out.println(o));

        //orElse()&o10.orElseGet();
        System.out.println("********************************************");
        //在optional为空值的情况下orElse和orElseGet都会执行方法
        Optional<String> o8 = Optional.empty();
        System.out.println(o8.orElse(method())); 
        System.out.println(o8.orElseGet(()->(method()))); 
        //当optional不为空时，orElseGet不会执行。
        Optional<String> o9 = Optional.of("我是o9");
        System.out.println(o9.orElse(method())); 
        System.out.println(o9.orElseGet(()->(method()))); 
        
       

    }

    private static String method(){
        System.out.println("此方法执行了");
        return "hehe";
    }
   
}
