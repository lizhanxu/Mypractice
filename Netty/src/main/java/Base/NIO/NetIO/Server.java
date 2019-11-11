package Base.NIO.NetIO;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @ClassName Server
 * @Description
 * @Date 2019/11/11
 * @Created by lizhanxu
 */
public class Server {
    //监听的端口号
    private static final int port = 8080;

    public static void main(String[] args) {

    }

    public static class MultiplexerServer implements Runnable {

        private Selector selector;

        private ServerSocketChannel serverSocketChannel;

        private volatile boolean stop;

        /**
         * 初始化多路复用器、绑定监听端口
         * @param port
         */
        public MultiplexerServer(int port) {

        }
        @Override
        public void run() {

        }
    }
}
