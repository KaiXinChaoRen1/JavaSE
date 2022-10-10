package d01_hehe.p02_UDP;

import java.io.IOException;
import java.net.*;

/**
 * 发送端（UDP最多64K？）
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1.套接字
        DatagramSocket ds = new DatagramSocket();

        //2.打包礼物
        //DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
        String s = "送给村长老丈人的礼物呜wuhuwuhu~~~";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        //数据包
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);


        //3.由码头发送包裹
        ds.send(dp);

        //4.付钱走羊
        ds.close();
    }
}
