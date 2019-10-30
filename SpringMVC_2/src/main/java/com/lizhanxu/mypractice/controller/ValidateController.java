package com.lizhanxu.mypractice.controller;

import com.lizhanxu.mypractice.pojo.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "index";
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
     * 没有接收Errors，验证到不符合要求的信息会抛出异常 BindException
     * @param trans
     * @return
     */
    @RequestMapping("/annotation4")
    public String annotationValidate4(@Valid Transaction trans) {
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
