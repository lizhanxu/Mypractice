package com.lizhanxu.mypractice.validator;

import java.lang.annotation.*;

/**
 * @ClassName ValidateString
 * @Description
 * @Date 2019/10/31 0:11
 * @Created by lizhanxu
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateString {
}
