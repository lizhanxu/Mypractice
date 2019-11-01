package NetIO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
}
