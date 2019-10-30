package com.lizhanxu.mypractice.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName StringValidator
 * @Description String类型入参的非空验证
 * @Date 2019/10/30 21:21
 * @Created by lizhanxu
 */
@Aspect
@Component
public class StringValidator {

//    private static String[] basicTypes = {"java.lang.Integer", "java.lang.Double",
//            "java.lang.Float", "java.lang.Long", "java.lang.Short",
//            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
//            "java.lang.String", "int", "double", "long", "short", "byte",
//            "boolean", "char", "float"};

    /**
     * 通过 @Pointcut来实现切点复用
     * 必须注解在方法上
     */
    @Pointcut("@annotation(ValidateString)")
    public void StringValidate() {
    }

    @Around("StringValidate()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();//获得连接点(原方法)的参数
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();//获得原方法
        Annotation[][] annotations = method.getParameterAnnotations();//获得原方法参数注解
        Class<?>[] parameterTypes = method.getParameterTypes();//获得原方法参数类型
        List<String> messages = Collections.synchronizedList(new ArrayList<>());//线程安全的ArrayList
        boolean Valid_flag;//是否有@Valid
        for (int i = 0; i < annotations.length; i++) {
            Valid_flag=false;
            for (int j = 0; j < annotations[i].length; j++) {
                if (annotations[i][j].annotationType()==NotNull.class&&Valid_flag) //同时有@NotNull和@Valid/@Validated注解
                {
                    if (parameterTypes[i]==String.class&&(String)args[i]==null) //入参类型为String且不为null
                    {
                        NotNull notNull = (NotNull)annotations[i][j];
                        messages.add(notNull.message());
                        break;//继续验证下一个参数
                    }
                }
                if (!Valid_flag) {
                    if (annotations[i][j].annotationType()==Valid.class
                            || annotations[i][j].annotationType()==Validated.class) //先验证有没有@Valid或者@Validated注解，如果有再验证@NotNull
                    {
                        j=-1;
                        Valid_flag=true;
                    }
                }
            }
        }
        if (messages.isEmpty()) {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            for (String message :
                    messages) {
                System.err.println(message);
            }
        }
        return null;
    }

}
