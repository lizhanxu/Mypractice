package first;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Niotest1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Netty/src/main/java/first/Niotest1.txt");
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining()>0){
            byte b = byteBuffer.get();
            System.out.println("Character: "+(char)b);
        }

        fileInputStream.close();
    }
}
