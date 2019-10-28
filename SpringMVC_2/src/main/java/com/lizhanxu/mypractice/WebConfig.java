package com.lizhanxu.mypractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @ClassName WebConfig
 * @Description
 * @Date 2019/10/28
 * @Created by lizhanxu
 */
@Configuration
@ComponentScan("com.lizhanxu.mypractice")
@EnableWebMvc//启用SpringWebMvc
public class WebConfig {

    @Bean  //忘记注入视图解析器了。。。。。。
    public ViewResolver initViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/");//编译后的路径，target下的路径
        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);//需要引入jstl包，要用到javax.servlet.jsp.jstl.core.Config     SpringMvc的默认视图为JstlView
        return viewResolver;
    }
}
