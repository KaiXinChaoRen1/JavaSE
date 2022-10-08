package com.p01_枚举类特点;

/**
 *  1.   所有枚举类都是Enum的子类（可以使用父类的方法）
 *  2.   我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
 *  3.   每一个枚举项其实就是该枚举的一个对象
 *  4.   枚举也是一个类，所以也可以去定义成员变量
 *  5.   枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，
 *     但是如果枚举类有其他的东西，这个分号就不能省略。所以干脆就不要省略
 *  6.   枚举类可以有构造器，但必须是private的。
 *  7.   枚举类也可以有抽象方法，但是枚举项必须重写该方法
 */


public enum Season {

    SPRING("春"){
        //如果枚举类中有抽象方法
        //那么在枚举项中必须要全部重写
        @Override
        public void show() {
            System.out.println(this.getName());
        }

    },

    SUMMER("夏"){
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },

    AUTUMN("秋"){
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    },

    WINTER("冬天"){
        @Override
        public void show() {
            System.out.println(this.getName());
        }
    };

    //成员变量
    private String name;
    //get方法
    public String getName(){
        return name;
    }

    //空参构造
    private Season(){}

    //有参构造
    private Season(String name){
        this.name = name;
    }

    //抽象方法
    public abstract void show();
}
