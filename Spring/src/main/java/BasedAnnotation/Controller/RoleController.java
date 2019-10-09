package BasedAnnotation.Controller;

import BasedAnnotation.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @ClassName RoleController
 * @Description
 * @Date 2019/10/9 20:52
 * @Created by lizhanxu
 */
@Controller//作用同@Component,@Component的别名
public class RoleController {

    @Autowired
    @Qualifier("roleServiceImpl")//按照名称注入
    private RoleService roleService;

    public void printRole() {
        roleService.printRoleInfo();
    }
}
