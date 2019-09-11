package Interceptor;

import java.lang.reflect.Method;

/**
 * @ClassName InterceptorImpl
 * @Author lizhanxu
 * @Date 2019/8/20  14:39
 * @Version V1.0.0
 */
public class InterceptorImpl implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;//不反射被代理对象原有方法
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");
    }
}
