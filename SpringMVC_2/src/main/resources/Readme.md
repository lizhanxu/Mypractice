####部分常用注解
    类注解：
    @RestController       组合注解，组合了@Controller和@ResponseBody，相当于把@ResponseBody注解在该控制器的每一个方法上。使用该注解的控制器只用于交互数据
    @RequestMapping       映射请求
    @SessionAttributes    设置会话属性(键值对)，只能注解类
    
    方法注解：
    @RequestMapping       映射请求，默认是GET方法
    
    方法参数注解：
    @RequestAttribute     获取request设置的attribute     默认不能为空
    @SessionAttribute     获取session设置的attribute     默认不能为空
    @CookieValue          获取Cookie中的值
    @RequestHeader        获取请求头信息中的值
    
    
####[@RequestBody与@ResponseBody详解](https://blog.csdn.net/kobejayandy/article/details/12690555)

####验证表单(以下两种方式不能同时使用)

#####使用JSR 303注解验证输入内容
    注解验证，验证顺序是无序的
    @Valid     注解在输入参数上，标明启用注解式验证
    
    验证注解，注解在Bean的成员变量上：
   ![](验证注解.png)
   
#####自定义验证器

####控制器通知(控制器增强)      原理 AOP
##### @ControllerAdvice     类注解
     * Specialization of {@link Component @Component} for classes that declare
     * {@link ExceptionHandler @ExceptionHandler}, {@link InitBinder @InitBinder}, or
     * {@link ModelAttribute @ModelAttribute} methods to be shared across
     * multiple {@code @Controller} classes.
    
     如果@ControllerAdvice没有指定Controller，默认在同一调度的Servlet中协助所有控制器
    
     不使用@ControllerAdvice下面三个注解只能作用于当前Controller，
     @ControllerAdvice与下面三个注解配合使用，可以作用于@ControllerAdvice指定的全部Controller
    
##### @InitBinder      方法注解     
    在请求到达控制器方法之前执行，每次请求都会执行一次 
    
    入参的数据绑定
        自定义验证器
        
        自定义属性编辑器来进行参数处理，将请求参数进行转换
        例如：Date类型转换
    
##### @ExceptionHandler     方法注解 
    注册一个控制器异常处理，当控制器发生异常时会跳转到该方法
    
    经常用到@ControllerAdvice + @ExceptionHandler进行全局的异常处理
    
##### @ModelAttribute           
    方法注解
    被@ModelAttribute注释的方法会在被作用的Controller的每个方法执行前被执行，用来 提前的、全局的 给每个model添加Attribute
    全局添加数据到model，用于共享某些数据
    @ModelAttribute 等价于在每个方法中使用model.addAttribute方法添加数据到模型对象
    
    方法参数注释
    该方法参数从model获取
    
    
HandlerExceptionResolver

@ExceptionHandler

https://blog.csdn.net/eson_15/article/details/51725470

https://blog.csdn.net/KingBoyWorld/article/details/78934841