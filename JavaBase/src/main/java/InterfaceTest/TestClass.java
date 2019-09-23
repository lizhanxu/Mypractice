package InterfaceTest;

/**
 * @ClassName TestClass
 * @Author lizhanxu
 * @Date 2019/9/23  10:08
 * @Version V1.0.0
 */
public class TestClass implements InterfaceTest {

    @Override
    public int compare(int a, int b) {
        return 0;
    }

    @Override
    public String toString() {
        return "TestClass{}";
    }

    public static void main(String[] args) {
        InterfaceTest testClass = new TestClass();
        testClass.sayHello();
    }
}
