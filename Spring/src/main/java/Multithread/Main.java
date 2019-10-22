package Multithread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description
 * @Date 2019/10/22
 * @Created by lizhanxu
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig_2.class);
        AsyncService asyncService = context.getBean(AsyncService.class);
        for (int i = 0; i < 10; i++) {
            asyncService.executeAsyncTask(i);
            asyncService.executeAsyncPlusTask(i);
        }
        context.close();
    }
}
