package Event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomEventPublisher_2
 * @Description
 * @Date 2019/10/21
 * @Created by lizhanxu
 */
@Component
public class CustomEventPublisher_2 implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;//使用ApplicationEventPublisher来发布事件
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(String msg) {
        CustomEvent customEvent = new CustomEvent(this,msg);
        publisher.publishEvent(customEvent);
    }
}
