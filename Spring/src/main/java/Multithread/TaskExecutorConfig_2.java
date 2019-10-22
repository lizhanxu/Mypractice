package Multithread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName TaskExecutorConfig_2
 * @Description
 * @Date 2019/10/22
 * @Created by lizhanxu
 */
@Configuration
@ComponentScan
@EnableAsync//开启异步任务支持
public class TaskExecutorConfig_2 {
    @Bean
    public Executor getExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
