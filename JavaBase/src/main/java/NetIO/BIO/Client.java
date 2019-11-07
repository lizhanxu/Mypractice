package NetIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName Client
 * @Description
 * @Date 2019/11/1
 * @Created by lizhanxu
 */
//https://blog.csdn.net/qq_41517936/article/details/81015711
public class Client {
    private static Socket socket = null;
    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public static void main(String[] args) {
        System.out.println("Client Start ...");
        try {
            socket = new Socket("127.0.0.1", 8080);
            out = new PrintWriter(socket.getOutputStream());//Socket的输出流，用以向客户端传输数据
            out.println("客户端请求：   " + new Date());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Socket的输入流，用以获取客户端传过来的数据
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.err.println("客户端异常：" + e.getMessage());
        } finally {//关闭资源
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (out != null) {
                out.close();
                out = null;
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {

                    System.out.println("服务端 finally 异常:" + e.getMessage());
                }
                socket = null;
            }
        }
    }
}
