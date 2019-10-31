package com.lizhanxu.mypractice.controller;

import com.lizhanxu.mypractice.pojo.Transaction;
import com.lizhanxu.mypractice.validator.ValidateString;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName ValidateController
 * @Description
 * @Date 2019/10/30
 * @Created by lizhanxu
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    /**
     * 注解@Valid   表示启用验证
     * @param trans
     * @param errors  Errors用于保存错误信息
     * @return
     */
    @RequestMapping("/annotation1")
    public String annotationValidate1(@Valid Transaction trans, Errors errors) {
        printErrors(errors);
        return "index";//由视图解析器生成对应视图
    }

    /**
     * 注解@Validated是Spring中对@Valid的变体，新增了分组校验的功能
     * @param trans
     * @param result  BindingResult是Spring中对Errors的扩展
     * @return
     */
    @RequestMapping("/annotation2")
    public String annotationValidate2(@Validated Transaction trans, BindingResult result) {
        printErrors(result);
        return "index";
    }

    /**
     * 会抛出异常，Errors/BindingResult应该直接声明在model(pojo)后面
     * @param msg
     * @param errors
     * @return
     */
    @RequestMapping("/annotation3")
    public String annotationValidate3(@Valid @NotNull String msg, Errors errors) {
        printErrors(errors);
        return "index";
    }

    /**
     * hibernate-validator校验框架只支持对Bean的校验，对诸如String,int之类的单个参数的校验是不起作用的，需要自己去实现校验AOP
     *
     * 自定义了StringValidator去校验
     * @param msg
     * @return
     */
    @RequestMapping("/annotation4")
    @ResponseBody
    @ValidateString//自己实现的@NotNull验证
    public String annotationValidate4(@Validated @NotNull(message = "id不能为空") String id,
                                      @Validated @NotNull(message = "msg不能为空") String msg) {
        return id + ":" + msg;
    }

    /**
     * 校验不通过，错误信息就会封装到Errors对象，如果不加Errors会抛出异常 BindException
     * @param trans
     * @return
     */
    @RequestMapping("/annotation5")
    public String annotationValidate5(@Valid Transaction trans) {
        return "index";
    }

    //打印验证错误信息
    private void printErrors(Errors errors) {
        // 是否存在错误
        if (errors.hasErrors()) {
            // 获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error : errorList) {
                // 打印字段错误信息
                System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
            }
        }
    }
}
