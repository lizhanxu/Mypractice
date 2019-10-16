package Servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ClassName MyRequestListener
 * @Description 监听ServletRequest对象，这个对象在Servlet容器接收到Http请求时被创建
 * @Date 2019/10/16
 * @Created by lizhanxu
 */
public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
