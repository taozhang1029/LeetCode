package com.kingsley.leetcode.util;

import org.junit.Test;

/**
 * 解决方案模板
 * Created by zhangtao1029 on 2021/7/15.
 */
public interface Solution {

    @Test
    void test();

    default Object solute(Object... args) {
        return SolutionProxy.invoke(this, args);
    }

}