package Autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Role
 * @Author lizhanxu
 * @Date 2019/8/21  16:35
 * @Version V1.0.0
 */
@Component("role")
public class Role {

    @Value("1")
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
