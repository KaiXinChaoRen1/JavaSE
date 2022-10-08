package d01_hehe.p02_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.找码头(参数为端口)
        DatagramSocket ds = new DatagramSocket(10000);

        //2,创建一个新的箱子
        byte [] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        //3.接收礼物,把礼物放到新的箱子中
        ds.receive(dp);

        //4.从新的箱子里拿数据（不指定长度的话，byte数组内部多余数据（默认是空格）都打印出来了）
        int length = dp.getLength();
        System.out.println(new String(bytes,0,length));

        //5.拿完走羊
        ds.close();
    }
}
