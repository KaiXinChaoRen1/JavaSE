package com.d02_IO流.p07_标准流;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 键盘输入字符串 回车后返回大写
 * 输入exit后，退出
 */
public class MyDemo {
    public static void main(String[] args) {

        BufferedReader bufferedReader=null;
        try{
            //转换流
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            //缓冲流
            bufferedReader = new BufferedReader(inputStreamReader);

            while (true){
                System.out.println("请输入字符串");
                String data=bufferedReader.readLine();
                if("exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                //转换成大写
                String s = data.toUpperCase();
                System.out.println(s);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
