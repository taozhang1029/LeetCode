package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * 剑指Offer42
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * Created by zhangtao552 on 2021/7/20.
 */
public class Solution42 implements Solution {
    @Test
    @Override
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solute((Object) nums);
    }

    /**
     * 1 <= nums.length <= 10^5
     * -100 <= nums[i] <= 100
     */
    @SolutionEntry
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;
    }
}
