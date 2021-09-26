package com.kingsley.leetcode.api;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 解决方案信息
 * Created by zhangtao1029 on 2021/9/23.
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SolutionInfo {

    @AliasFor("value")
    String solutionName() default "";

    @AliasFor("solutionName")
    String value() default "";

    String requirements() default "";

}
