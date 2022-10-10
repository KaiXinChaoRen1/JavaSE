package com.d02_io.p01_FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  try   catch 异常（IO的三步代码，每一步都可能出异常）
 */
public class OutputDemo6 {
    public static void main(String[] args) {

        FileOutputStream fos = null;

        try {
            //System.out.println(2/0);  //造个异常
            fos = new FileOutputStream("D:\\iioo\\a.txt");
            fos.write(100);
        }catch(IOException e){
           e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();            //finally内部再来个try catch
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
