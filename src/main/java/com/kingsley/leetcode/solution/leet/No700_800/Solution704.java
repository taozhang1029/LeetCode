package com.kingsley.leetcode.solution.leet.No700_800;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Class Solution704
 * @Time 2021/9/6 上午11:13
 * @Author kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/binary-search/">704. 二分查找</a>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Solution704 implements Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{-1, 0, 3, 5, 9, 12}, 5);
    }

    @SolutionEntry
    public int search(int[] nums, int target) {
        int p = 0, q = nums.length;
        while (p < q) {
            int mid = p + (q - p) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                p = mid + 1;
            } else {
                q = mid;
            }
        }
        return -1;
    }

}
