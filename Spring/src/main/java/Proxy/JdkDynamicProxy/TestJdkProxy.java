package Proxy.JdkDynamicProxy;

/**
 * @ClassName TestJdkProxy
 * @Author lizhanxu
 * @Date 2019/8/20  10:53
 * @Version V1.0.0
 */
public class TestJdkProxy {

    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系，因为挂在接口HelloWorld下，所以申明代理对象HelloWorld proxy
        HelloWorld proxy = (HelloWorld)jdkProxyExample.bind(new HelloWorldImpl());
        //注意，此时HelloWorld对象已经是一个代理对象，它会进入代理的逻辑方法invoke里
        proxy.sayHelloWorld();
    }

}
