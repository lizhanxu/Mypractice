package String;

/**
 * @ClassName CharTest
 * @Author lizhanxu
 * @Date 2019/9/18  14:46
 * @Version V1.0.0
 */
public class CharTest {
    public static void main(String[] args) {

        //unicode码兼容ASCII码
        char testchar = '我';

        //输出‘我’的十进制unicode码
        System.out.println((int)testchar);

        //十进制转十六进制字符串
        String number = Integer.toHexString((int) testchar);
        System.out.println(number);

        //十六进制字符串转十进制数
        int Hexnumber = Integer.parseInt(number, 16);
        System.out.println(Hexnumber);

        char ch = '\u6211';
        System.out.println(ch);

        String str = "\u6211";
        System.out.println(str);
    }
}
