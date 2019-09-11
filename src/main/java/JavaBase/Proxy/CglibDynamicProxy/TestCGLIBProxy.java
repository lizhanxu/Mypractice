package JavaBase.Proxy.CglibDynamicProxy;

import JavaBase.JavaReflect.ReflectServiceImpl;

/**
 * @ClassName TestCGLIBProxy
 * @Author lizhanxu
 * @Date 2019/8/20  14:20
 * @Version V1.0.0
 */
public class TestCGLIBProxy {

    public static void main(String[] args) {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl)cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello();
    }
}
