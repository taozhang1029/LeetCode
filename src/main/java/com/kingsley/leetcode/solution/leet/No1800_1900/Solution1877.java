package com.kingsley.leetcode.solution.leet.No1800_1900;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * 2021/7/20 每日一题
 * <p>
 * 一个数对(a,b)的 数对和等于a + b。最大数对和是一个数对数组中最大的数对和。
 * <p>
 * 比方说，如果我们有数对(1,5)，(2,3)和(4,4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
 * 给你一个长度为 偶数n的数组nums，请你将 nums中的元素分成 n / 2个数对，使得：
 * <p>
 * nums中每个元素恰好在 一个数对中，且
 * 最大数对和的值 最小。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和。
 * <p>
 * Created by zhangtao552 on 2021/7/20.
 */
public class Solution1877 implements Solution {

    @Test
    @Override
    public void test() {
        int[] nums = {3, 5, 4, 2, 4, 6};
        solute((Object) nums);
    }

    @SolutionEntry
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = -1;
        int p = 0, q = nums.length - 1;
        while (p < q) {
            result = Math.max(result, nums[p++] + nums[q--]);
        }

        return result;
    }

}
