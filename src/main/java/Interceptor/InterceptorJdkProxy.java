package Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName InterceptorJdkProxy
 * @Author lizhanxu
 * @Date 2019/8/20  14:42
 * @Version V1.0.0
 */
public class InterceptorJdkProxy implements InvocationHandler {

    //真实对象
    private Object target;

    //拦截器全限定名，用于反射
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target,String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个【代理占位】
     * @param target 真实对象
     * @param interceptorClass 拦截器Class
     * @return 代理对象【占位】
     */
    public static Object bind(Object target,String interceptorClass){
        //取代代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target,interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy 代理对象
     * @param method 方法，被调用方法
     * @param args 方法参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null){
            //没有拦截器则直接返回原有方法
            return method.invoke(target,args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if (interceptor.before(proxy,target,method,args)){
            //反射原有对象方法
            result = method.invoke(target,args);
        }else {//返回false执行around方法
            interceptor.around(proxy,target,method,args);
        }
        //调用后置方法
        interceptor.after(proxy,target,method,args);
        return result;
    }
}
