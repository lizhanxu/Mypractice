package Base.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description     基于BIO的Server
 * @Date 2019/11/1
 * @Created by lizhanxu
 */
public class Server {
    //监听的端口号
    private static final int port = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);//负责监听来自客户端的Socket请求
            System.out.println("Server Start ...");
            while (true) {//采用循环不断地接收来自客户端的请求
                Socket client = serverSocket.accept();//如果接收到一个客户端的Socket连接请求，返回一个与该客户端对应的Socket，否则该方法将一直处于等待状态，线程阻塞
                new Thread(new ServerHandler(client)).start();//每一个Socket请求创建一个线程去处理
            }
        } catch (IOException e) {
            System.err.println("服务器异常：" + e.getMessage());
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
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));//Socket的输入
                out = new PrintWriter(this.socket.getOutputStream(),true);//Socket的输出

                System.out.println(in.readLine());//接收数据

                System.out.print("请输入:\t");
                String s = new BufferedReader(new InputStreamReader(System.in)).readLine();//键盘输入
                out.println(s);//发送数据,close方法在close之前会flush一次
            } catch (IOException e) {
                System.err.println("服务器异常： " + e.getMessage());
            } finally {//关闭资源
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
}
