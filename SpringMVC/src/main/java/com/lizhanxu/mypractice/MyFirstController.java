package com.lizhanxu.mypractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName com.lizhanxu.mypractice.MyFirstController
 * @Description
 * @Date 2019/10/23
 * @Created by lizhanxu
 */
//Spring MVC初始化的时候会将@Controller、@RequestMapping解析生成HandlerMapping(处理器映射)
@Controller
@RequestMapping("/my")//指定对应URL
public class MyFirstController {

    @RequestMapping("/home")//指定对应URL
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();//模型和视图
        mv.setViewName("index");//视图的逻辑名称
        return mv;
    }
}
