package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 0 <= n <= 100
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/submissions/
 * Created by zhangtao552 on 2021/7/21.
 */
public class Solution10_1 implements Solution {

    @Test
    @Override
    public void test() {
        solute(5);
    }

    @SolutionEntry(countTime = true)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int pre = 0;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            int tmp = curr;
            curr += pre;
            curr %= (1e9 + 7);
            pre = tmp;
        }

        return curr;
    }
}
