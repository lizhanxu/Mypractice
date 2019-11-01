package NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOTest
 * @Author lizhanxu
 * @Date 2019/9/25  17:20
 * @Version V1.0.0
 */
public class NIOTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("JavaBase/src/main/java/NIO/Readme.md");
        FileChannel fileChannel = fileInputStream.getChannel();//从流中获得通道
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);//创建缓冲区
        fileChannel.read(byteBuffer);//从通道中读取数据写入缓冲区
        byteBuffer.flip();//写模式转换为读模式
        while (byteBuffer.remaining()>0){//读取数据
            char b = byteBuffer.getChar();//读取一个字节
            System.out.print(b);
        }
        fileInputStream.close();//关闭流
    }
}
