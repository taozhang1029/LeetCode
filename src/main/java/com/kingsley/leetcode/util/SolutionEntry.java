package com.kingsley.leetcode.util;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 方法入口注解
 * Created by zhangtao1029 on 2021/7/15.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface SolutionEntry {

    boolean useJsonResult() default false;

    boolean countTime() default false;

    boolean onlyResult() default false;

    // 优先级
    int priority() default 0;

}
