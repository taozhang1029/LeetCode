package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 0 <= n <= 100
 * <p>
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * Created by zhangtao552 on 2021/7/21.
 */
public class Solution10_2 extends Solution {

    @Test
    @Override
    public void test() {
        solute(70000);
    }

    @SolutionEntry(countTime = true)
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int MOD = (int) (1e9 + 7);
        int curr_1 = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = curr;
            curr = (curr + curr_1) % MOD;
            curr_1 = tmp;
        }

        return curr;
    }
}
