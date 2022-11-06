package Algorithm.d04_kmp;

public class Violence {

    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);

    }

    // 暴力匹配算法实现（弱智算法）
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();         //把字符串转成字符数组
        char[] s2 = str2.toCharArray();

        int i = 0; // i索引指向s1
        int j = 0; // j索引指向s2
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j]) {//匹配成功一个字符
                i++;
                j++;
            } else { //没有匹配成功
                i = i - j + 1;      //i回到上次开始匹配的下一个位置
                j = 0;              //j回到0重新匹配
            }
        }
        if (j == s2.length) {       //j匹配到头了 说明匹配成功
            return i - j;           //返回i的位置
        } else {
            return -1;
        }
    }
}
