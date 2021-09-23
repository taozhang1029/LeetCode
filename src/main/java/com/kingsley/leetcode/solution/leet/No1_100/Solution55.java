package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: zhangtao552
 * @time: 2021/8/13 16:47
 * @description 跳跃游戏
 * @see <a href="https://leetcode-cn.com/problems/jump-game/">55. 跳跃游戏</a>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 */
public class Solution55 extends Solution {

    @Test
    @Override
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        solute(nums);
    }

    @SolutionEntry
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        visit[0] = true;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                continue;
            }
            Arrays.fill(visit, i, Math.min(i + nums[i] + 1, n), true);
        }
        return visit[n - 1];
    }
}
