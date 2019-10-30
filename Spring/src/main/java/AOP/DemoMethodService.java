package AOP;

import org.springframework.stereotype.Service;

/**
 * @ClassName DemoMethodService
 * @Description 使用方法规则被拦截类
 * @Date 2019/10/11
 * @Created by lizhanxu
 */
@Service
public class DemoMethodService {
    public void add() {
        System.out.println("DemoMethodService   add");
    }
}
