package com.d02_io.p01_FileOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 写入字节数组
 */
public class OutputDemo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("d06_io\\a.txt");

        byte [] bys = {97,98,99};
        fos.write(bys);

        byte [] bys2 = {100,101,102,103};
        fos.write(bys2,0,2);

        fos.close();
    }
}
