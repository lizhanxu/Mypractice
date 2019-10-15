package Servlet;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName Servlet.SpringWebMain
 * @Description
 * @Date 2019/10/15
 * @Created by lizhanxu
 */
public class SpringWebMain {
    public static void main(String[] args) {
        System.out.println("反射main方法成功！");
        ApplicationContext context = SpringUtils.getApplicationContext();
        HelloBean hello = context.getBean(HelloBean.class);
        hello.sayHello();
    }
}
