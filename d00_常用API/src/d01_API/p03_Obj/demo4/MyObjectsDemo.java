package d01_API.p03_Obj.demo4;

import java.util.Objects;

public class  MyObjectsDemo {
    public static void main(String[] args) {

        Student s = new Student("撒斯给",17);
        String result = Objects.toString(s);    //返回参数中对象的字符串表示形式。
        System.out.println(result);
        System.out.println(s);


        Student s1 = new Student("那路托",16);
        Student s2= null;
        String result2 = Objects.toString(s2, "我来保护村子");   //如果对象为空,那么返回第二个参数.
        System.out.println(result2);


        Student s3 = null;
        System.out.println(Objects.isNull(s3));     //是否为空  ：true
        System.out.println(Objects.nonNull(s3));     //是否不为空：false

    }
}
