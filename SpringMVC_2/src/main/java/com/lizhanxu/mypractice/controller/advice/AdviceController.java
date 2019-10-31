package com.lizhanxu.mypractice.controller.advice;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AdviceController
 * @Description
 * @Date 2019/10/31
 * @Created by lizhanxu
 */
@Controller
@RequestMapping("advice")
public class AdviceController {

    /***
     *
     * @param date 日期，在@initBinder 绑定的方法有注册格式
     * @param model 数据模型，@ModelAttribute方法会先于请求方法运行
     * @return map
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String, Object> testAdvice(Date date, @NumberFormat(pattern = "##,###.00") BigDecimal amount, Model model) {
        Map<String, Object> map = new HashMap<>();
        //由于@ModelAttribute注解的通知会在控制器方法前运行，所以这样也会取到数据
        map.put("project_name", model.asMap().get("messageContent"));
        if (date != null) {
            map.put("date", new SimpleDateFormat("yyyy-MM-dd").format(date));
        }
        map.put("amount", amount);
        return map;
    }

    @RequestMapping("ModelAttribute")
    @ResponseBody
    public String ModelAttributeTest(@ModelAttribute("messageContent") String content) {//从model获取参数
        System.out.println(content);
        return content;
    }

    /**
     * 测试异常.
     */
    @RequestMapping("/exception")
    public void exception() {
        throw new RuntimeException("测试异常跳转");
    }
}
