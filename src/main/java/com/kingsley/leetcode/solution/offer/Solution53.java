package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Class Offer53
 * @Time 2021/7/16 上午12:31
 * @Author kingsley
 * @Project LeetCode
 * @Description 剑指offer53 在排序数组中查找数字 I
 * <p>
 * 两次二分查找
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution53 implements Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    @SolutionEntry
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        if (right == 0) {
            return 0;
        }

        int p = left;
        int q = right;

        while (p < q) {
            int mid = p + (q - p) / 2;
            int curr = nums[mid];
            if (curr > target) {
                q = mid - 1;
            } else if (curr < target) {
                p = mid + 1;
            } else {
                q = mid;
            }
        }

        if (p >= right || nums[p] != target) {
            return 0;
        }
        left = p;

        q = right - 1;
        while (p <= q) {
            int mid = p + (q - p) / 2;
            if (nums[mid] > target) {
                q = mid - 1;
            } else {
                p = mid + 1;
            }
        }
        right = q;

        return right - left + 1;
    }
}
