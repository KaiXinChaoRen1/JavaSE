package Algorithm.d04_kmp;

import java.util.Arrays;

public class KMPAlgorithm {

    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] next = kmpNext("abacabab");
        System.out.println("next=" + Arrays.toString(next));

        /*int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15*/

    }

    /**
     * kmp搜索算法
     * @param str1 原字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 返回第一个匹配的位置，没匹配到就返回-1
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for(int i = 0, j = 0; i < str1.length(); i++) {             //i不回退，只回退j
            while( j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) {        //说明找到
                return i - j + 1;
            }
        }
        return  -1;
    }

    /**
     * 获取到某个字符串的部分匹配值表
     * @param s 字符串s
     * @return
     */
    public static  int[] kmpNext(String s) {
        int[] next = new int[s.length()];           //创建一个跟字符串长度相同的数组用来保存部分匹配值
        next[0] = 0;                                //如果字符串是长度为1时 部分匹配值一定是0
        for(int i = 1, j = 0; i < s.length(); i++) {
            while(j>0 && s.charAt(i) != s.charAt(j)) {      //当不相等时j要回退
                j = next[j-1];              //背下即可          abcabcdxxxabcabca
            }
            if(s.charAt(i) == s.charAt(j)) {         //当s.charAt(i) == s.charAt(j) 满足时，部分匹配值就是+1
                j++;
            }
            next[i] = j;        //长度为i的串匹配值设成j
        }
        return next;
    }
}
