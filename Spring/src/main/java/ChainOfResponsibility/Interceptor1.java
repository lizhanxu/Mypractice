package ChainOfResponsibility;

import Interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * @ClassName Interceptor1
 * @Author lizhanxu
 * @Date 2019/8/20  15:47
 * @Version V1.0.0
 */
public class Interceptor1 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】的before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】的after方法");
    }
}
