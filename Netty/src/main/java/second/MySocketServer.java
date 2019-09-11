package second;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MySocketServer {

    public static void main(String[] args) throws InterruptedException {
        //bossGroup获取连接，什么都不做丢给workerGroup
        //handler()对bossGroup发挥作用
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        //workerGroup拿到连接之后对连接进行编解码
        //childHandler()对workerGroup发挥作用
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //业务处理，另起一个业务线程池来处理业务，business

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,workerGroup).
                    channel(NioServerSocketChannel.
                            class).childHandler(new MySocketServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
