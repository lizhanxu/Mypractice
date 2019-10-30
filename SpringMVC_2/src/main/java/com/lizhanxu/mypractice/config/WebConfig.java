package com.lizhanxu.mypractice.config;

import com.lizhanxu.mypractice.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @ClassName WebConfig
 * @Description   配置类  实现WebMvcConfigurer或者继承WebMvcConfigurationSupport
 *
 *                继承WebMvcConfigurationSupport时添加拦截器失败
 * @Date 2019/10/28
 * @Created by lizhanxu
 */
@Configuration
@ComponentScan("com.lizhanxu.mypractice")
@EnableWebMvc//启用SpringWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Bean  //忘记注入视图解析器了。。。。。。
    public ViewResolver initViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/");//编译后的路径，target下的路径
        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);//需要引入jstl包，要用到javax.servlet.jsp.jstl.core.Config     SpringMvc的默认视图为JstlView
        return viewResolver;
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor interceptor = new MyInterceptor();
        registry
                //注册拦截器
                .addInterceptor(interceptor);
                //添加拦截路径，如果不指定添加，则拦截所有
//                .addPathPatterns("/**");//拦截所有
    }
}
