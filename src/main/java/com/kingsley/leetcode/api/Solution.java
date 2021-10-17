package com.kingsley.leetcode.api;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 解决方案模板
 * Created by zhangtao1029 on 2021/7/15.
 */
@SolutionInfo
@Slf4j
public abstract class Solution {

    public abstract void test();

    protected Object solute(Object... args) {
        return SolutionProxy.invoke(this, args);
    }

    protected Object solute(Object arg) {
        return solute(new Object[]{arg});
    }

    protected void checkResult(Object realValue, Object... args) {
        if (realValue.getClass().isArray()) {
            checkResult((int[])realValue,args);
        } else  {
            String s = realValue.toString();
            try {
                int res = Integer.parseInt(s);
                checkResult(res, args);
                return;
            } catch (ClassCastException e1) {
                try {
                    boolean res = Boolean.parseBoolean(s);
                    checkResult(res,args);
                    return;
                } catch (ClassCastException e2) {

                }
            }
            Object result = solute(args);
            boolean equals = realValue.equals(result);
            if (!equals) {
                log.error("解答错误：算法输出为 {}， 正确答案为 {}", result, realValue);
            } else {
                log.info("用例通过");
            }
        }
    }

    private void checkResult(int realValue, Object... args) {
        int result = (int) solute(args);
        if (result != realValue) {
            log.error("解答错误：算法输出为 {}， 正确答案为 {}", result, realValue);
        } else {
            log.info("用例通过");
        }
    }

    private void checkResult(int[] realValue, Object... args) {
        int[] result = (int[]) solute(args);
        boolean equals = Arrays.equals(result, realValue);
        if (!equals) {
            log.error("解答错误：算法输出为 {}， 正确答案为 {}", result, realValue);
        } else {
            log.info("用例通过");
        }
    }

    private void checkResult(boolean realValue, Object... args) {
        boolean result = (boolean) solute(args);
        if (result == realValue) {
            log.error("解答错误：算法输出为 {}， 正确答案为 {}", result, realValue);
        } else {
            log.info("用例通过");
        }
    }

}
