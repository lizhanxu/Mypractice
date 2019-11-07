package NetIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeClient
 * @Description
 * @Date 2019/11/7
 * @Created by lizhanxu
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                port = 8080;
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The Time Server is start in port: " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
//                new Thread(new  TimeServerHandler(socket))
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class TimeServerHandler implements Runnable {
        @Override
        public void run() {

        }
    }

}
