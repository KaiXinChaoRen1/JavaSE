package d01_hehe.P07_TCP_对话;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while((b = is.read())!=-1){
            System.out.print((char) b);
        }

//        OutputStream os = accept.getOutputStream();
//        os.write("反弹".getBytes());


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("尼四安鹅");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
