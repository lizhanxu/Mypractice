package Event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName Main
 * @Description
 * @Date 2019/10/21
 * @Created by lizhanxu
 */
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        CustomEventPublisher_1 publisher_1 = context.getBean(CustomEventPublisher_1.class);
        publisher_1.publish("publisher_1 : Hello Spring Event");
        CustomEventPublisher_2 publisher_2 = context.getBean(CustomEventPublisher_2.class);
        publisher_2.publish("publisher_2 : Hello Spring Event");
        context.close();
    }
}
