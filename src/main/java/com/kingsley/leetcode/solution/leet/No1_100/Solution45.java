package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/13 17:36
 * @description
 * @see <a href="https://leetcode-cn.com/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Solution45 implements Solution {

    @Test
    @Override
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        solute(nums);
    }

    @SolutionEntry
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;  // 上次跳跃可达范围右边界（下次的起跳点）
        int maxPosition = 0; // 目前能跳到的最远位置
        int steps = 0; // 跳跃次数
        for (int i = 0; i < n - 1; i++) {
            // 记录最大可到达位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { // 到达上次跳跃能到达的右边界了
                end = maxPosition; // 目前能跳到的最远位置变成了下次起跳位置
                steps++; // 进入下一次跳跃
            }
        }
        return steps;
    }
}
