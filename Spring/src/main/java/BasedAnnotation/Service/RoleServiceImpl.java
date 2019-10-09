package BasedAnnotation.Service;

import BasedAnnotation.Pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RoleServiceImpl
 * @Author lizhanxu
 * @Date 2019/8/21  16:42
 * @Version V1.0.0
 */
@Service("roleServiceImpl")//作用同@Component,@Component的别名
public class RoleServiceImpl implements RoleService {

    /**
     * 默认是根据类型装配
     * 默认required=true，即装配失败会抛出异常
     * 使用方式：
     * ①注入(修饰)属性
     * ②Bean的setter方法也可以用@Autowired来完成注入(修饰)
     * ③注入(修饰)构造器参数
     */
    @Autowired
    private Role role;

    @Override
    public void printRoleInfo( ) {
        System.out.println("id = "+role.getId());
        System.out.println("roleName = "+role.getRoleName());
        System.out.println("note = "+role.getNote());
    }
}
