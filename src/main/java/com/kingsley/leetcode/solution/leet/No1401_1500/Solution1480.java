package com.kingsley.leetcode.solution.leet.No1401_1500;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Class Solution1480
 * @Time 2021/8/28 19:18
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 * @see <a href="https://leetcode-cn.com/problems/running-sum-of-1d-array/">1480. 一维数组的动态和</a>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 */
public class Solution1480 extends Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{3,1,2,10,1});
    }

    @SolutionEntry
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
