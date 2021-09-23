package com.kingsley.leetcode.util;

/**
 * 解决方案模板
 * Created by zhangtao1029 on 2021/7/15.
 */
@SolutionInfo
public abstract class Solution {

    protected abstract void test();

    protected Object solute(Object... args) {
        return SolutionProxy.invoke(this, args);
    }

    protected Object solute(Object arg) {
        return solute(new Object[]{arg});
    }

}
