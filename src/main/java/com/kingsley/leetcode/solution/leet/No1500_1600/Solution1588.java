package com.kingsley.leetcode.solution.leet.No1500_1600;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Time 2021/8/29 10:58
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 * @see <a href="https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/">1588. 所有奇数长度子数组的和</a>
 * 给你一个正整数数组 arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中所有奇数长度子数组的和 。
 * <img src="../../../../../../../resources/image/leet1588.png"/>
 */
public class Solution1588 implements Solution {
    @Test
    @Override
    public void test() {
        solute(new int[]{1, 4, 2, 5, 3});
    }

    @SolutionEntry
    public int sumOddLengthSubarrays(int[] arr) {
        int result = Arrays.stream(arr).sum();
        int n = arr.length;
        for (int step = 2; step < n; step += 2) {
            for (int i = 0; i + step < n; i++) {
                for (int j = 0; j <= step; j++) {
                    result += arr[i + j];
                }
            }
        }
        return result;
    }

}
