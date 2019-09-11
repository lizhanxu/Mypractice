package Autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName RoleServiceImpl
 * @Author lizhanxu
 * @Date 2019/8/21  16:42
 * @Version V1.0.0
 */
@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private Role role = null;

    @Override
    public void printRoleInfo( ) {
        System.out.println("id = "+role.getId());
        System.out.println("roleName = "+role.getRoleName());
        System.out.println("note = "+role.getNote());
    }
}
