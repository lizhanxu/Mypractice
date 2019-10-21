package Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomEventHandler
 * @Description 事件监听器，实现ApplicationListener接口，指定监听的事件类型
 * @Date 2019/10/21
 * @Created by lizhanxu
 */
@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    //使用该方法对消息进行接收处理
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println("接收到Publisher发布的消息："+customEvent.getMsg());
    }
}
