package Base.AIO.handler;

import Base.AIO.Server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @ClassName AcceptCompletionHandler
 * @Description
 *                       CompletionHandler接口的实现类作为异步操作完成的回调
 *                       AIO的异步操作由底层操作系统去做，应用程序只需接收操作系统的通知
 * @Date 2019/11/13
 * @Created by lizhanxu
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {
    //异步操作完成，回调
    @Override
    public void completed(AsynchronousSocketChannel result, AsyncServerHandler attachment) {
        //AsynchronousServerSocketChannel的accept方法，接收到请求，系统将回调传入到CompletionHandler实例的completed中
        attachment.serverSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    //异步操作失败，回调
    @Override
    public void failed(Throwable exc, AsyncServerHandler attachment) {
        attachment.latch.countDown();
    }
}
