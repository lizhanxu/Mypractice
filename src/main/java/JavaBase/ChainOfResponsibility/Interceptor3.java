package JavaBase.ChainOfResponsibility;

import JavaBase.Interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * @ClassName Interceptor3
 * @Author lizhanxu
 * @Date 2019/8/20  15:48
 * @Version V1.0.0
 */
public class Interceptor3 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】的before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器3】的after方法");
    }
}
