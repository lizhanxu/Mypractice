package Multithread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName AsyncService
 * @Description
 * @Date 2019/10/22
 * @Created by lizhanxu
 */
@Async//表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法。
//方法自动被注入，使用ThreadPoolTaskExecutor作为TaskExecutor来执行任务
@Service
public class AsyncService {
    public void executeAsyncTask(int i) {
        System.out.println("线程："+Thread.currentThread().getName()+"  执行异步任务:  "+i);
    }

    public void executeAsyncPlusTask(int i) {
        System.out.println("线程："+Thread.currentThread().getName()+"  执行异步加1任务:  "+(i+1));
    }
}
