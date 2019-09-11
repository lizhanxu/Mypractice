package Interceptor;

import java.lang.reflect.Method;

/**
 * @ClassName Interceptor
 * @Author lizhanxu
 * @Date 2019/8/20  14:35
 * @Version V1.0.0
 */
public interface Interceptor {
    /**
     *
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 运行方法参数
     * @return 当返回为true时,反射真实对象的方法；当返回为false时，则调用around方法
     */
    boolean before(Object proxy, Object target, Method method,Object[] args);

    /**
     *
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 运行方法参数
     * @return
     */
    void around(Object proxy,Object target,Method method,Object[] args);

    /**
     * 在反射真实对象方法或者around方法执行之后，调用after方法
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 方法
     * @param args 运行方法参数
     * @return
     */
    void after(Object proxy,Object target,Method method,Object[] args);
}
