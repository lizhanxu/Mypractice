package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName Listener.MyServletListener
 * @Description 监听ServletContext对象
 * @Date 2019/10/15
 * @Created by lizhanxu
 */
public class MyServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("自定义监听器  监听到contextInitialized方法被调用");
        //反射main方法
        try {
            Class.forName("Main").getDeclaredMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("自定义监听器  监听到contextDestroyed方法被调用");
    }
}
