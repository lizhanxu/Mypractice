package AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName LogAspect
 * @Description 切面
 * @Date 2019/10/11
 * @Created by lizhanxu
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(AOP.Action)")//通过 @Pointcut来实现切点复用
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before1(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("前置通知   "+action.name());
    }

    @After("annotationPointCut()")
    public void after1(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("后置通知   "+action.name());
    }

    @Before("execution(* AOP.DemoMethodService.*(..))")//注意第一个*后面跟空格
    public void before2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("前置通知   方法规则式拦截"+method.getName()+"方法");
    }
}
