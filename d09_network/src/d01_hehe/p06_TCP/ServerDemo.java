package d01_hehe.p06_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //2. 等待客户端连接
        //System.out.println("我还在等，来人啊");
        Socket accept = ss.accept();        //accept方法是阻塞的，连不上就等
        //System.out.println("终于连上了，wuhu~");

        //3.获得输入流对象
        InputStream is = accept.getInputStream();
        int b;
        while((b = is.read()) != -1){       //read方法是阻塞的，读不到就等
            System.out.print((char) b);
        }


        //4.释放资源
        is.close();
        ss.close();
    }
}
