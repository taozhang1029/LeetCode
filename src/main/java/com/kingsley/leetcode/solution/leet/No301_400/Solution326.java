package com.kingsley.leetcode.solution.leet.No301_400;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

/**
 * @Time 2021/9/23 10:13
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/power-of-three/">326. 3的幂</a>
 */
@SolutionInfo(solutionName = "3的幂", requirements = "不使用循环或者递归来完成？")
public class Solution326 extends Solution {

    @Test
    @Override
    public void test() {
        solute(27);
        solute(0);
        solute(9);
        solute(45);
    }

    @SolutionEntry(priority = 1)
    public boolean isPowerOfThree1(int n) {
        if (n < 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    @SolutionEntry
    public boolean isPowerOfThree(int n) {
        final int POWER_3_MAX = 1162261467;
        return n > 0 && POWER_3_MAX % n == 0;
    }
}
