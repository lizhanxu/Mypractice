package BasedAnnotation.Service;

import BasedAnnotation.Service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl2
 * @Description
 * @Date 2019/10/9 20:51
 * @Created by lizhanxu
 */
@Service//作用同@Component,@Component的别名
@Primary//多个实现类时，优先使用该类注入
public class RoleServiceImpl2 implements RoleService {
    @Override
    public void printRoleInfo() {
        System.out.println("RoleServiceImpl2被装配！");
    }
}
