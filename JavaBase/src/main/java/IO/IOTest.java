package IO;

import java.io.*;

/**
 * @ClassName IOTest
 * @Author lizhanxu
 * @Date 2019/9/25  10:35
 * @Version V1.0.0
 */
public class IOTest {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("JavaBase/src/main/java/IO/Readme.md"))
        {
            char[] buff = new char[9];
            fileReader.read(buff);
            System.out.println(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fin = new FileInputStream("JavaBase/src/main/java/IO/Readme.md"))
        {
            byte[] buff = new byte[7];
//            while (fin.read(buff) > 0) {
//                System.out.print(new String(buff));
//            }
            fin.read(buff);
            System.out.println(new String(buff));
            fin.read(buff);
            System.out.println(new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
