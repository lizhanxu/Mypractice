package com.lizhanxu.mypractice.validator;

import com.lizhanxu.mypractice.pojo.Transaction;
import com.lizhanxu.mypractice.pojo.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @ClassName CustomValidator
 * @Description    自定义验证器
 * @Date 2019/10/30
 * @Created by lizhanxu
 */
public class CustomValidator implements Validator {

    /**
     * 判断当前验证器是否用于验证clazz类型的pojo
     * @param clazz   pojo类型
     * @return  true  启动验证  ;  false  则不再验证
     */
    @Override
    public boolean supports(Class<?> clazz) {
        //判断验证是否为Transaction，如果是则进行判断[修改为：验证]
        return User.class.equals(clazz);
    }

    /**
     * 验证pojo的合法性
     * @param target   pojo请求对象
     * @param errors   错误信息
     */
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getName().equals("小明")) {
            //加入错误信息
            errors.rejectValue("name", null, "姓名不能为小明");
        }
    }
}
