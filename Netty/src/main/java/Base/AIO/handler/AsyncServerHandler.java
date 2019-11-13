package Base.AIO.handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName AsyncServerHandler
 * @Description
 * @Date 2019/11/13
 * @Created by lizhanxu
 */
public class AsyncServerHandler implements Runnable {
    private int port;

    CountDownLatch latch; //同步计数器

    AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncServerHandler(int port) {
        this.port = port;
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The Server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);//初始化同步计数器   计数初值count=1
        serverSocketChannel.accept(this,new AcceptCompletionHandler());
        try {
            latch.await();//阻塞当前线程直到count=0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
