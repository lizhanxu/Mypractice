import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyFirstController
 * @Description
 * @Date 2019/10/23
 * @Created by lizhanxu
 */
@Controller
public class MyFirstController {

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
