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
    public static void main(String[] args) {
        System.out.println("Client Start ...");
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        //3599 2849  2299
//        int sum = 289*2+1729+439+279+299;
//        System.out.println(sum);
//        System.out.println(6100-sum);
        try {
            socket = new Socket("127.0.0.1", 8080);
//            out = new PrintWriter(socket.getOutputStream());//Socket的输出流，用以向客户端传输数据
//            out.println("客户端请求：   "+new Date());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//Socket的输入流，用以获取客户端传过来的数据
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.err.println("客户端异常："+e.getMessage());
        }finally {//关闭资源
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
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
