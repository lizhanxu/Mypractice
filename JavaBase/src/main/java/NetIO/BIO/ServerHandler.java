package NetIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName ServerHandler
 * @Description
 * @Date 2019/11/1
 * @Created by lizhanxu
 */
public class ServerHandler implements Runnable {
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
            //Socket的输出流，用以向客户端传输数据
            PrintWriter out = new PrintWriter(this.socket.getOutputStream());
            out.println("建立连接");
//            String content = null;
//            while (true) {//读取客户端传过来的数据
//                content = in.readLine();//读取一行
//                if (content == null) {
//                    break;
//                }
//                System.out.println(content);
//            }
            out.println("服务器返回当前时间为："+System.currentTimeMillis());//向客户端返回当前时间
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
