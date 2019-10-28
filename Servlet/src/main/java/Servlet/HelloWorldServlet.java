package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @ClassName Readme.HelloWorldServlet
 * @Description
 * @Date 2019/10/14
 * @Created by lizhanxu
 */
//@WebServlet(urlPatterns = "/helloWorld.html")//Servlet3.0及以上使用，等同于web.xml的配置
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = -3297595207537168724L;
    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        //parameter是客户端传过来的请求参数，不是头信息，可以是url里面的，也可以是body里面的
        Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        // 设置响应内容类型
        resp.setContentType("text/html");//MIME类型
        // 实际的逻辑是在这里
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void init() throws ServletException {
        message = "Hello World";
    }
}