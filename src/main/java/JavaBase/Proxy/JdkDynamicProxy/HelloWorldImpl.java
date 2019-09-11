package JavaBase.Proxy.JdkDynamicProxy;

/**
 * @ClassName HelloWorldImpl
 * @Author lizhanxu
 * @Date 2019/8/20  9:41
 * @Version V1.0.0
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
