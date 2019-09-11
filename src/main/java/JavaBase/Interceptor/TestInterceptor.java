package JavaBase.Interceptor;

import JavaBase.Proxy.JdkDynamicProxy.HelloWorld;
import JavaBase.Proxy.JdkDynamicProxy.HelloWorldImpl;

/**
 * @ClassName TestInterceptor
 * @Author lizhanxu
 * @Date 2019/8/20  15:15
 * @Version V1.0.0
 */
public class TestInterceptor {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "JavaBase.Interceptor.InterceptorImpl");
        proxy.sayHelloWorld();
    }
}
