package JavaBase.ChainOfResponsibility;

import JavaBase.Interceptor.InterceptorJdkProxy;
import JavaBase.Proxy.JdkDynamicProxy.HelloWorld;
import JavaBase.Proxy.JdkDynamicProxy.HelloWorldImpl;

/**
 * @ClassName TestChain
 * @Author lizhanxu
 * @Date 2019/8/20  15:54
 * @Version V1.0.0
 */
public class TestChain {
    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "JavaBase.ChainOfResponsibility.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
                "JavaBase.ChainOfResponsibility.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
                "JavaBase.ChainOfResponsibility.Interceptor3");
        proxy3.sayHelloWorld();
    }
}
