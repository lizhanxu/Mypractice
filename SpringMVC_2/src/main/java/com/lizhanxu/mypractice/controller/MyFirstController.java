package com.lizhanxu.mypractice.controller;

import com.lizhanxu.mypractice.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyFirstController
 * @Description
 * @Date 2019/10/23
 * @Created by lizhanxu
 */
//Spring MVC初始化的时候会将@Controller、@RequestMapping解析生成HandlerMapping(处理器映射)
@Controller
//@RequestMapping("/my")//指定对应URL
public class MyFirstController {

    /**
     *
     * @return 返回字符串会被当做逻辑视图被视图解析器解析
     */
    @RequestMapping("homepage")
    public String goto_home() {
        return "index";
    }

    @RequestMapping("/my/home")//指定对应URL       第一个"/"有没有效果完全一样，在请求的url中，同一处的"/"1个或多个没影响
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();//模型和视图
        mv.setViewName("index");//视图的逻辑名称
        return mv;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)//指定对应URL,默认为GET
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();//模型和视图
        mv.setViewName("index");//视图的逻辑名称
        return mv;
    }

    /**
     * 注解@RequestParam 获取请求参数
     * 注解@SessionAttribute 获取session中的对象，相当于HttpSession的getAttribute方法获取对象
     *
     * required = false   允许参数为空，默认required为true，即默认请求参数是不能为空的(会抛出异常)
     * @param id
     */
    @RequestMapping("/transParam_1")
    public ModelAndView getParam_1(@RequestParam(value = "userid",required = false) Long id) {
        System.out.println("接收到的id为  "+id);

        ModelAndView mv = new ModelAndView();//模型和视图
        mv.setViewName("index");//视图的逻辑名称
        return mv;
    }

    //和上面的方法等同，但使用HttpServletRequest会导致依赖servlet包(即依赖于Servlet容器,即依赖Servlet API)，不利于扩展和测试
    @RequestMapping("/transParam_2")
    public ModelAndView getParam_2(HttpServletRequest request) {
        if (request.getParameter("userid") != null) {
            System.out.println(Long.parseLong(request.getParameter("userid")));
        }else
            System.out.println("null");

        ModelAndView mv = new ModelAndView();//模型和视图
        mv.setViewName("index");//视图的逻辑名称
        return mv;
    }

    @RequestMapping("/transParam_3")
    public ModelAndView getParam_3(@RequestParam("userid") String id) {
        User user = new User();
        user.setId(id);
        ModelAndView mv = new ModelAndView();

        //添加数据模型
        mv.addObject("user", user);

        //设置视图，非逻辑视图不会被视图解析器解析，SpringMvc的默认视图为JstlView
        //需要引入jackson-databind，因为要用到com.fasterxml.jackson.databind.Module
        mv.setView(new MappingJackson2JsonView());

        return mv;
    }


}
