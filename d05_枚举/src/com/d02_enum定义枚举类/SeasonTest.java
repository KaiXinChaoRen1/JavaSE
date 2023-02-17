package com.d02_enum定义枚举类;

public class SeasonTest {
    public static void main(String[] args) {

        System.out.println(Season.SUMMER);
        System.out.println(Season.SUMMER.getSeasonName());
        System.out.println(Season.SUMMER.getSeasonDescription());
    }
}

enum Season {

    SPRING("春", "困"),
    SUMMER("夏", "蚊"),
    AUTUMN("秋", "乏"),
    WINTER("冬", "冷");

    private final String seasonName;
    private final String seasonDescription;

    // get方法
    public String getSeasonName() {
        return seasonName;
    }

    // get方法
    public String getSeasonDescription() {
        return seasonDescription;
    }

    private Season(String seasonName, String seasonDescription) {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }

}
