package d01_hehe.p06_TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 发送端
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1,创建一个Socket对象
        Socket socket = new Socket("127.0.0.1",10000);

        //2.获取一个IO流开始写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello world".getBytes());       //字节流要发字节


        //3.释放资源
        os.close();     //关流的时候会给服务器一个结束标记，告诉read别阻塞了
        socket.close(); //关闭连接用到'四次挥手'
    }
}
