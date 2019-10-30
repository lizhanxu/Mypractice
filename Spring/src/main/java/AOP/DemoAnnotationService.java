package AOP;

import org.springframework.stereotype.Service;

/**
 * @ClassName DemoAnnotationService
 * @Description 使用注解的被拦截类
 * @Date 2019/10/11
 * @Created by lizhanxu
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add() {
        System.out.println("DemoAnnotationService   add");
    }
}
