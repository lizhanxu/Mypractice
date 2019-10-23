package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName Readme.ErrorHandler
 * @Description
 * @Date 2019/10/15
 * @Created by lizhanxu
 */
public class ErrorHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取异常
        Throwable throwable = (Throwable)
                req.getAttribute("javax.servlet.error.exception");
        //获取状态码
        Integer statusCode = (Integer)
                req.getAttribute("javax.servlet.error.status_code");
        //获取Servlet的名称
        String servletName = (String)
                req.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null){
            servletName = "Unknown";
        }
        //获取有关URL调用Servlet的信息
        String requestUri = (String)
                req.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null){
            requestUri = "Unknown";
        }
        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "Error/Exception信息";

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        out.println("<h1>异常信息实例演示</h1>");
        if (throwable == null && statusCode == null){
            out.println("<h2>错误信息丢失</h2>");
            out.println("请返回 <a href=\"" +
                    resp.encodeURL("http://localhost:8080/") +
                    "\">主页</a>。");
        }else if (statusCode != null) {
            out.println("错误代码 : " + statusCode);
        }else{
            out.println("<h2>错误信息</h2>");
            out.println("Servlet Name : " + servletName +
                    "</br></br>");
            out.println("异常类型 : " +
                    throwable.getClass( ).getName( ) +
                    "</br></br>");
            out.println("请求 URI: " + requestUri +
                    "<br><br>");
            out.println("异常信息: " +
                    throwable.getMessage( ));
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
