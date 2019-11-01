package NetIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description
 * @Date 2019/11/1
 * @Created by lizhanxu
 */
//https://blog.csdn.net/qq_41517936/article/details/81015711
public class Client {
    public static void main(String[] args) {
        System.out.println("Client Start ...");
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Socket的输入流，用以获取客户端传过来的数据
            PrintWriter out = new PrintWriter(socket.getOutputStream());//Socket的输出流，用以向客户端传输数据
            out.println("客户端请求： 服务器你好   "+System.currentTimeMillis());
            String content = null;
            while (true) {
                content = in.readLine();
                if (content == null) {
                    break;
                }
                System.out.println(content);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            System.err.println("客户端异常："+e.getMessage());
        }finally {//关闭资源
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    socket = null;
                    System.out.println("服务端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}
