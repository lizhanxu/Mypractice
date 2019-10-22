package ScheduledTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ScheduledService
 * @Description
 * @Date 2019/10/22
 * @Created by lizhanxu
 */
@Service
public class ScheduledService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//声明计划任务
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行一次"+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 15 17 ? * *")//声明计划任务，每天17点15分执行
    public void fixTimeExecution() {
        System.out.println("在指定时间"+dateFormat.format(new Date())+"执行");
    }
}
