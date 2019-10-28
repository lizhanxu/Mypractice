package com.lizhanxu.mypractice;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ClassName MyWebAppInitializer
 * @Description  依赖servlet包
 *               两种方式：
 *               ①继承AbstractAnnotationConfigDispatcherServletInitializer
 *               ②或者实现WebApplicationInitializer接口重载onStartup方法
 * @Date 2019/10/28
 * @Created by lizhanxu
 */
public class MyWebAppInitializer
//        extends AbstractAnnotationConfigDispatcherServletInitializer
        implements WebApplicationInitializer
{

    //实现WebApplicationInitializer的方法

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }

    //重写AbstractAnnotationConfigDispatcherServletInitializer中的方法

//    //获取Spring IoC容器的Java配置类，用以装载各类Spring Bean
//    //该方法返回为空，则不加载自定义的Bean到Spring IoC容器中
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class<?>[]{};
//    }
//
//    //DispatcherServlet的URI映射关系配置
//    //获取各类Spring MVC的URI和控制器的映射关系类，用以生成Web请求的上下文
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        //可以返回Spring的Java配置文件数组
//        return new Class<?>[]{WebConfig.class};
//    }
//
//    //定义DispatcherServlet拦截的请求
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
}
