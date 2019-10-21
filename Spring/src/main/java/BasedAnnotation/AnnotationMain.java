package BasedAnnotation;

import BasedAnnotation.Component.DataSourceTest;
import BasedAnnotation.Controller.RoleController;
import BasedAnnotation.Pojo.Role;
import BasedAnnotation.Service.RoleService;
import Proxy.JdkDynamicProxy.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

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
//   file:///  代表文件系统，绝对路径
//@ImportResource("file:///WorkSpace/Mypractice/Spring/src/main/resource/HelloWorldConfig.xml")
@ImportResource("classpath:HelloWorldConfig.xml")//classpath:代表在Maven约定的资源文件夹下面(即${basedir}/src/main/resources)，注意路径一定要严格按照约定
public class AnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationMain.class);

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorldImpl");
        helloWorld.sayHelloWorld();

        Role role = context.getBean(Role.class);
        System.out.println(role.getId());

        RoleService roleService = context.getBean(RoleService.class);
        roleService.printRoleInfo();

        RoleController roleController = context.getBean(RoleController.class);
        roleController.printRole();

        DataSourceTest dataSourceTest = context.getBean(DataSourceTest.class);
        dataSourceTest.query();

        context.close();//释放资源

    }
}
