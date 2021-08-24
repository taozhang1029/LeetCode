package com.kingsley.leetcode.solution.leet.No500_600;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/3 11:06
 * @description
 * @see <a href="https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/">581. 最短无序连续子数组</a>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class Solution581 implements Solution {
    @Test
    @Override
    public void test() {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        solute(nums); // 5
    }

    @SolutionEntry
    public int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }
        int[] maxs = new int[N + 1];
        int[] mins = new int[N + 1];

        maxs[0] = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxs[i + 1] = Math.max(maxs[i], nums[i]);
        }

        mins[N] = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            mins[i] = Math.min(mins[i + 1], nums[i]);
        }

        int p, q;

        for (p = 0; p < N; p++) {
            if (nums[p] > mins[p]) {
                break;
            }
        }

        for (q = N - 1; q >= 0; q--) {
            if (nums[q] < maxs[q]) {
                break;
            }
        }

        return Math.max(q - p + 1, 0);
    }
}
