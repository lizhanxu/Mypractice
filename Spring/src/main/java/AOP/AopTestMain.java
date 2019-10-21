package AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AopTestMain
 * @Description
 * @Date 2019/10/12
 * @Created by lizhanxu
 */
public class AopTestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        demoAnnotationService.add();
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoMethodService.add();
        context.close();//释放资源，养成良好的习惯
    }
}
