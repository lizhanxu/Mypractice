package BasedAnnotation;

import BasedAnnotation.Component.DataSourceTest;
import BasedAnnotation.Controller.RoleController;
import BasedAnnotation.Pojo.Role;
import BasedAnnotation.Service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName AnnotationMain
 * @Author lizhanxu
 * @Date 2019/8/21  16:38
 * @Version V1.0.0
 */
//@ComponentScan自动扫描组件，将组件装配到IoC容器中
//@ComponentScan有basePackages和basePackageClasses两个属性
//basePackages可以配置一个Java包的数组，Spring会扫描对应的包和子包
//basePackageClasses可以配置多个类，Spring会根据类所在的包扫描包和子包    (basePackageClasses = {Role.class, RoleServiceImpl.class})
//默认是扫描当前包的路径
//不要采用多个@ComponentScan，因为一旦重复扫包就会产生重复Bean实例
@ComponentScan
public class AnnotationMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationMain.class);
        Role role = context.getBean(Role.class);
        System.out.println(role.getId());

        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo();

        RoleController roleController = context.getBean(RoleController.class);
        roleController.printRole();

        DataSourceTest dataSourceTest = context.getBean(DataSourceTest.class);
        dataSourceTest.query();

    }
}
