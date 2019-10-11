package AOP;

import java.lang.annotation.*;

/**
 * @ClassName Action
 * @Description 编写拦截规则的注解
 * 和xml一样注解本身并没有功能，注解和xml都是一种元数据，元数据即解释数据的数据，这就是所谓的配置。
 * 注解的功能来自用这个注解的地方。
 * @Date 2019/10/11
 * @Created by lizhanxu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
