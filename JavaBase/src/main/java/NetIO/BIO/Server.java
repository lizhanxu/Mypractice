package NetIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName Server
 * @Description  基于BIO的Server
 * @Date 2019/11/1
 * @Created by lizhanxu
 */
public class Server {
    //监听的端口号
    private static final int port= 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);//负责监听来自客户端的Socket请求
            System.out.println("Server Start ...");
            while (true) {//采用循环不断地接收来自客户端的请求
                Socket client = serverSocket.accept();//如果接收到一个客户端的Socket连接请求，返回一个与客户端对应的Socket，否则该方法将一直处于等待状态，线程阻塞
                new Thread(new ServerHandler(client)).start();//每一个Socket请求创建一个线程去处理
            }
        } catch (IOException e) {
            System.err.println("服务器异常："+e.getMessage());
        }
    }

    private static class ServerHandler implements Runnable {
        //当前线程所处理的Socket
        private Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                //Socket的输入流，用以获取客户端传过来的数据
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                String content = null;
                while (true) {//读取客户端传过来的数据
                    content = in.readLine();//读取一行
                    if (content == null) {
                        break;
                    }
                    System.out.println(content);
                }
                //Socket的输出流，用以向客户端传输数据
                PrintWriter out = new PrintWriter(this.socket.getOutputStream());
                out.println("建立连接");
                out.println("服务器返回当前时间为："+new Date());//向客户端返回当前时间
                out.close();
                in.close();
            } catch (IOException e) {
                System.err.println("服务器异常："+e.getMessage());
            } finally {
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
}
