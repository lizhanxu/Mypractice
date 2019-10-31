package com.lizhanxu.mypractice.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName CommonControllerAdvice
 * @Description
 * @Date 2019/10/31
 * @Created by lizhanxu
 */
@ControllerAdvice("com.lizhanxu.mypractice.controller.advice")
public class CommonControllerAdvice {

    /**
     * 初始化WebDataBinder(数据绑定)，主要用于对请求参数的处理：验证，转换
     *
     * 转换请求参数中的日期字符串为Date类型，SpringMVC默认不支持这个格式的转换
     *
     * @param binder   WebDataBinder是用来绑定请求参数到指定的属性编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //针对日期类型的格式化，其中CustomDateEditor是Spring提供的Date属性编辑器
        //它的boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    /**
     * 全局添加数据到model，用于共享某些数据
     * @param model
     * @return 如果有返回值，则该对象会保存在model的attributeValue中，attributeName默认为返回类型首字母小写
     */
    @ModelAttribute("messageContent")//指定attributeName
    public String populateModel() {
        return "Hello Model AttributeValue";//该对象会保存在model的attributeValue中
    }

    /**
     * 异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
     * 注解@ControllerAdvice+@ExceptionHandler  全局异常处理
     * @return
     */
    @ExceptionHandler(Exception.class)//处理的异常类型
    @ResponseBody
    public String handleException(HttpServletResponse response,Exception e) {
//        response.setCharacterEncoding("UTF-8");    //没用，会被MessageConverter覆盖
        e.printStackTrace();
        return e.getMessage();
    }
}
