package d01_hehe.p04_UDP_组播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //组播的接收端
        MulticastSocket ms = new MulticastSocket(10000);

        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);

        //把当前计算机绑定一个组播地址
        ms.joinGroup(InetAddress.getByName("224.0.1.0"));

        ms.receive(dp);

        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(data,0,length));

        ms.close();
    }
}
