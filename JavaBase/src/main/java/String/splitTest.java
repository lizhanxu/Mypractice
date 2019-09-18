package String;

/**
 * @ClassName splitTest
 * @Author lizhanxu
 * @Date 2019/9/18  17:34
 * @Version V1.0.0
 */
public class splitTest {
    public static void main(String[] args) {
        /**
         * split方法的使用
         * 1.limit>0:
         * 模式匹配将被最多应用n-1次，数组的长度将不会大于n，数组的最后一项将包含所有超出最后匹配的定界符的输入。
         * 2.limit<0:
         * 模式匹配将应用尽可能多的次数，而且数组的长度是任何长度。
         * 3.limit=0:
         * 模式匹配将被应用尽可能多的次数，数组可以是任何长度，并且结尾空字符串将被丢弃。
         * limit默认为0
         */
        //以 \\ 作为分隔符
        PrintStrs("aaa\\bbb\\bccc".split("\\\\",-1));//单反斜杠标识转义,通过正则表达式去匹配分隔符
        PrintStrs("aaa\\bbb\\bccc\\".split("\\\\",-1));
        PrintStrs("aaa\\bbb\\bccc\\\\".split("\\\\",-1));

        String string = "boo:and:foo";
        System.out.print(": 0");
        PrintStrs(string.split(":"));
        System.out.print(": 1");
        PrintStrs(string.split(":",1));
        System.out.print(": 2");
        PrintStrs(string.split(":",2));
        System.out.print(": 5");
        PrintStrs(string.split(":",5));
        System.out.print(": -2");
        PrintStrs(string.split(":",-2));
        System.out.print("o 0");
        PrintStrs(string.split("o"));
        System.out.print("o 1");
        PrintStrs(string.split("o",1));
        System.out.print("o 2");
        PrintStrs(string.split("o",2));
        System.out.print("o 3");
        PrintStrs(string.split("o",3));
        System.out.print("o 4");
        PrintStrs(string.split("o",4));
        System.out.print("o 5");
        PrintStrs(string.split("o",5));
        System.out.print("o 6");
        PrintStrs(string.split("o",6));
        System.out.print("o -2");
        PrintStrs(string.split("o",-2));
    }
    public static void PrintStrs(String[] strs) {
        int i;
        System.out.print("{");
        for (i = 0;i<strs.length-1;i++) {
            System.out.print("\""+strs[i]+"\""+",");
        }
        System.out.println("\""+strs[i]+"\""+"}");
    }
}
