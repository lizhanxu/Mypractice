package com.lizhanxu.mypractice.config;

import com.lizhanxu.mypractice.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.List;

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
@EnableAspectJAutoProxy//提供织入支持
public class WebConfig implements WebMvcConfigurer {

    @Bean  //忘记注入视图解析器了。。。。。。
    public ViewResolver initViewResolver() {
        //InternalResourceView是逻辑视图
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/");//编译后的路径，target下的路径
        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);//需要引入jstl包，要用到javax.servlet.jsp.jstl.core.Config     JstlView视图主要为JSP的渲染而服务
        return viewResolver;
    }

    /**
     * 添加HttpMessageConverter
     * 解决中文字符乱码的问题
     * SpringMVC默认注入的StringHttpMessageConverter是ISO_8859_1，且该默认字符集为final，不能更改，因此需要添加一个新的StringHttpMessageConverter用来解析中文
     * public static final Charset DEFAULT_CHARSET = StandardCharsets.ISO_8859_1;
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter messageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(messageConverter);
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
