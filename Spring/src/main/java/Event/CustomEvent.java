package Event;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName CustomEvent
 * @Description 自定义事件
 * @Date 2019/10/21
 * @Created by lizhanxu
 */
public class CustomEvent extends ApplicationEvent {
    private String msg;

    public CustomEvent(Object source) {
        super(source);
    }

    public CustomEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
