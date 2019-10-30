package com.lizhanxu.mypractice.controller;

import com.lizhanxu.mypractice.pojo.User;
import com.lizhanxu.mypractice.validator.CustomValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName CustomValidateController
 * @Description
 * @Date 2019/10/30
 * @Created by lizhanxu
 */
@Controller
public class CustomValidateController {

    /**
     * 将验证器和控制器绑定
     * 该控制器绑定了自定义验证器之后，该控制器内的所有@Valid将启用自定义验证器，无法使用注解验证(会抛出异常)
     * @param binder
     */
    @InitBinder
    public void initBinder(DataBinder binder) {
        // 数据绑定器加入验证器
        binder.setValidator(new CustomValidator());
    }

    //@Valid开启验证
    @RequestMapping("/validator")
    public String validator(@Valid User user, Errors errors) {
        printErrors(errors);
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
