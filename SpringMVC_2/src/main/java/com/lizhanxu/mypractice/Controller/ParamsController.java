package com.lizhanxu.mypractice.Controller;

import com.lizhanxu.mypractice.pojo.User;
import com.lizhanxu.mypractice.pojo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @ClassName ParamsController
 * @Description
 * @Date 2019/10/29
 * @Created by lizhanxu
 */
@Controller
@RequestMapping("params") //    有没有"/"效果完全一样，在请求的url中，同一处的"/"1个或多个没影响
public class ParamsController {

    /**
     * 传递过来的参数名称和HTTP的请求参数保持一致，则无需注解也可以获取参数
     * 允许请求参数为空
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("commonParams")
    public ModelAndView commonParams(String id, String name) {
        System.out.println(id);
        System.out.println(name);
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("id", id);
        mv.addObject("name", name);
        return mv;
    }

    /**
     * pojo的属性要和HTTP的请求参数保持一致，则无需注解也可以获取参数
     * 允许请求参数为空
     * @param user
     * @return
     */
    @RequestMapping("commonParamPojo")
    public ModelAndView commonParamPojo(User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * 当前后端的参数名称不一致时，使用@RequestParam来实现转换
     * 被@RequestParam注解的请求参数，默认情况下不能为空
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("requestParam")
    public ModelAndView requestParam(@RequestParam("user_id") String id, @RequestParam("user_name") String name) {
        System.out.println(id);
        System.out.println(name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * 使用URL传递参数
     * 只支持GET请求
     * 注解@PathVariable的请求参数不能为空
     * @param id
     * @return
     */
    @RequestMapping("getUserId/{user_id}")
    public ModelAndView pathVariable(@PathVariable("user_id") String id) {
        System.out.println(id);
        User user = new User();
        user.setId(id);
        ModelAndView mv = new ModelAndView();
        //绑定数据模型
        mv.addObject(user);
        //设置为Json视图
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    /**
     * 传递JSON参数
     * 注解@RequestBody用来接收JSON参数
     * @param userVo
     * @return
     */
    @RequestMapping("findUsers")
    public ModelAndView findUsers(@RequestBody UserVo userVo) {
        System.out.println(userVo);
        ModelAndView mv = new ModelAndView();
        //添加数据模型
        mv.addObject(userVo.getPageParams());
        //添加数据模型
        mv.addObject(userVo.getUser());
        //设置视图
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }



    /**
     * 将表单(form)数据序列化，传递给后台，数据将以id=xxx&&name=xxx传递
     * <p>
     * 前端写法举例：     data:$("form").serialize(),
     * <p>
     * 后端服务器用  commonParams(String id, String name)  方法去获取参数
     */



    /**
     * 通过返回字符串来进行重定向
     * @param model 重定向数据模型，Spring MVC 会自动初始化它
     * @param id
     * @param name
     * @return   Spring MVC 约定，当返回的字符串带有redirect的时候，认为需要重定向
     */
    @RequestMapping("redirectGetUser1")
    public String redirectGetUser1(Model model, String id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        System.out.println(user);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "redirect:./commonParams";
    }

    /**
     * 通过返回视图来进行重定向
     * @param mv
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("redirectGetUser2")
    public ModelAndView redirectGetUser2(ModelAndView mv, String id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        System.out.println(user);

        mv.addObject("id", id);
        mv.addObject("name", name);

        mv.setViewName("redirect:./commonParams");
        return mv;
    }

    /**
     * 重定向传递pojo
     * @param ra
     * @param user
     * @return
     */
    @RequestMapping("redirectGetUserJson")
    public String redirectGetUserJson(RedirectAttributes ra, User user) {
        System.out.println(user);
        ra.addFlashAttribute("user", user);//使用该方法后，SpringMVC会将数据保存到Session中，重定向后会从Session中读取数据并清除
        return "redirect:./commonParamPojo";
    }


}
