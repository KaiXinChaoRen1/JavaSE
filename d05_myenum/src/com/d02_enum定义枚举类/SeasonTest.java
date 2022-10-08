package com.d02_enum定义枚举类;

public class SeasonTest {
    public static void main(String[] args) {

        System.out.println(Season.SUMMER);
    }
}


enum Season{

    SPRING("春","困"),
    SUMMER("瞎","蚊"),
    AUTUMN("秋","乏"),
    WINTER("冬","冷");


    private final String seasonName;
    private final String seasonDescription;


    private Season(String seasonName,String seasonDescription){
        this.seasonName=seasonName;
        this.seasonDescription=seasonDescription;
    }

}
