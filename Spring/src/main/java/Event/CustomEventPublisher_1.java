package Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomEventPublisher_1
 * @Description
 * @Date 2019/10/21
 * @Created by lizhanxu
 */
@Component
public class CustomEventPublisher_1 {

    //注入ApplicationContext用来发布事件
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new CustomEvent(this,msg));
    }
}
