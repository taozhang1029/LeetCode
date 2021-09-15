package com.kingsley.leetcode.util;

/**
 * 解决方案模板
 * Created by zhangtao1029 on 2021/7/15.
 */
public interface Solution {

    void test();

    default Object solute(Object... args) {
        return SolutionProxy.invoke(this, args);
    }

    default Object solute(Object arg) {
        return solute(new Object[]{arg});
    }

}
