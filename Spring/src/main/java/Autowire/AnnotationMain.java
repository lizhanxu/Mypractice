package Autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AnnotationMain
 * @Author lizhanxu
 * @Date 2019/8/21  16:38
 * @Version V1.0.0
 */
public class AnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = context.getBean(Role.class);
        System.out.println(role.getId());

        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo();

    }
}
