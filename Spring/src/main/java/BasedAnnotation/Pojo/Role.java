package BasedAnnotation.Pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Role
 * @Author lizhanxu
 * @Date 2019/8/21  16:35
 * @Version V1.0.0
 */
//@Component代表IoC会把这个类扫描生成Bean实例，该注解只能注解在类上
@Component("role")//value="role"相当于XML中的Bean的id
public class Role {

    @Value("1")//通过这个注解注入一些简单值，String会自动转型
    private Long id;

    @Value("role_name_1")
    private String roleName;

    @Value("role_note_2")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
