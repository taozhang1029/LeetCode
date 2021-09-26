package com.kingsley.leetcode.solution.leet.No301_400;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/6 9:34
 * @description
 * @see <a href="https://leetcode-cn.com/problems/integer-break/">343. 整数拆分</a>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 本题与{@linkplain com.kingsley.leetcode.solution.offer.Solution14_1 剑指Offer14-I.剪绳子} 相同
 */
public class Solution343 extends Solution {

    @SolutionEntry
    public int integerBreak(int n) {
        return n <= 3 ? n - 1 : (int) (Math.pow(3, n / 3) * 4 / (4 - n % 3));
    }

    @Test
    @Override
    public void test() {

    }
}
