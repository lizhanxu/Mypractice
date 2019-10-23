package Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ClassName Listener.MyRequestListener
 * @Description 监听ServletRequest对象，这个对象在Servlet容器接收到Http请求时被创建
 * @Date 2019/10/16
 * @Created by lizhanxu
 */
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求结束");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听到请求");
    }
}
