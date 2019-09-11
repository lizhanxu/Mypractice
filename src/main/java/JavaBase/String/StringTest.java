package JavaBase.String;

/**
 * @ClassName StringTest
 * @Author lizhanxu
 * @Date 2019/9/10  15:58
 * @Version V1.0.0
 */

public class StringTest {
    public static void main(String[] args) {
        /**
         * 字符串直接量如"abc"存储在字符串常量池中
         * "=="对于两个引用类型变量，只有当这两个引用指向同一个对象时，返回true
         */
        String a = "abc";//在字符串常量池中创建"abc",引用a指向"abc"

        String b = "abc";//检查到常量池中已经存在"abc"，固不再创建，引用b直接指向"abc"

        String c = "a"+"bc";//"a"+"bc"在编译时就确定下来，检测到常量池中存在"abc"，固引用c直接指向"abc"

        /**
         * 1、先判断常量池中是否已有"abc",没有则在常量池中创建
         * 2、调用构造器以常量池中的"abc"作为参数,在堆内存中新创建一个String对象,引用d指向这个String对象
         */
        String d = new String("abc");

        /**
         * 1、先判断常量池中是否已有"abc",没有则在常量池中创建
         * 2、调用构造器以常量池中的"abc"作为参数,在堆内存中新创建一个String对象,引用e指向这个String对象
         */
        String e = new String("abc");

        System.out.println(a == b);//引用a和引用b指向常量池中同一个字符串直接量地址

        System.out.println(a == c);//引用a和引用c指向常量池中同一个字符串直接量地址

        System.out.println(a == d);//引用a指向常量池中的"abc"，引用d指向堆内存中一个String对象

        System.out.println(d == e);//new了两个String对象，引用d和引用e分别指向这两个对象

        String f = "a";
        String j = "bc";
        String h = f + j;//f + j不能在编译时就确定先来，固不能引用常量池中的字符串

        System.out.println(a == h);
    }
}
