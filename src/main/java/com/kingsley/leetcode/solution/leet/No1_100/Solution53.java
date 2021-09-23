package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.type.DynamicProgramming;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/7 16:39
 * @Author Kingsley
 * @Project LeetCode
 * @Description 动态规划
 * @see <a href="https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子序和</a>
 */
public class Solution53 extends Solution implements DynamicProgramming{

    @Test
    @Override
    public void test() {
        solute(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    @SolutionEntry
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int tmp = 0;
        for (int num : nums) {
            if (tmp < 0) {
                tmp = num;
            } else {
                tmp += num;
            }
            result = Math.max(result, tmp);
        }
        return result;
    }
}
