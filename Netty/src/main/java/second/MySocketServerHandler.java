package second;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MySocketServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        //打印出远程设备的地址，即客户端的地址
        System.out.println(channelHandlerContext.channel().remoteAddress()+","+s);
        channelHandlerContext.channel().writeAndFlush("form server: "+ UUID.randomUUID());

    }
}
