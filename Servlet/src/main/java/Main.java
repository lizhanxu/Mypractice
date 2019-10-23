import Bean.HelloBean;
import Util.SpringUtils;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName Readme.Main
 * @Description
 * @Date 2019/10/15
 * @Created by lizhanxu
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("反射main方法成功！");
        ApplicationContext context = SpringUtils.getApplicationContext();
        HelloBean hello = context.getBean(HelloBean.class);
        hello.sayHello();
    }
}
