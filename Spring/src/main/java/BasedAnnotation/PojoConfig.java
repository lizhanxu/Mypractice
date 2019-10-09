package BasedAnnotation;

import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName PojoConfig
 * @Author lizhanxu
 * @Date 2019/8/21  16:37
 * @Version V1.0.0
 */
//@ComponentScan有basePackages和basePackageClasses两个属性
//basePackages可以配置一个Java包的数组，Spring会扫描对应的包和子包
//basePackageClasses可以配置多个类，Spring会根据类所在的包扫描包和子包
//默认是扫描当前包的路径
//不要采用多个@ComponentScan，因为一旦重复扫包就会产生重复Bean实例
@ComponentScan(basePackageClasses = {Role.class,RoleServiceImpl.class})
public class PojoConfig {
}
