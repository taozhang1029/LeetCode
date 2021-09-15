package com.kingsley.leetcode.solution.leet.No101_200;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/15 17:34
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/find-peak-element/">162. 寻找峰值</a>
 */
public class Solution162 implements Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{1, 2, 1, 3, 5, 6, 4});
    }

    @SolutionEntry(solutionName = "寻找峰值", requirements = "时间复杂度为 O(log n)")
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
