package Base.AIO;

import Base.AIO.handler.AsyncServerHandler;

/**
 * @ClassName Server
 * @Description
 * @Date 2019/11/13
 * @Created by lizhanxu
 */
public class Server {
    private static final int port = 8080;

    public static void main(String[] args) {
        AsyncServerHandler server = new AsyncServerHandler(port);
        new Thread(server,"AIO-AsyncServerHandler-001").start();
    }
}
