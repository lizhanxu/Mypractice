package ScheduledTask;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName TaskSchedulerConfit
 * @Description
 * @Date 2019/10/22
 * @Created by lizhanxu
 */
@EnableScheduling//开启定时任务支持
@ComponentScan
@Configuration
public class TaskSchedulerConfig {
}
