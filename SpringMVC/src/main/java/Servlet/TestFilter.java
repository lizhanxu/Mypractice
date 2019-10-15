package Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName TestFilter
 * @Description
 * @Date 2019/10/15
 * @Created by lizhanxu
 */
public class TestFilter implements Filter {

    //在过滤器中，可以使用FilterConfig接口对象来访问初始化参数。
    //只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestFilter init");
        // 获取初始化参数
        String site = filterConfig.getInitParameter("Site");
        // 输出初始化参数
        System.out.println(site);
    }

    //责任链模式
    //请求一次执行一次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TestFilter doFilter");
        // 把请求传回过滤链
        chain.doFilter(request,response);
    }

    //只执行一次
    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
        System.out.println("TestFilter destroy");
    }
}
