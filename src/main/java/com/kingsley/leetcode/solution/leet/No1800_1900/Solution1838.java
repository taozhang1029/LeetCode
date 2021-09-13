package com.kingsley.leetcode.solution.leet.No1800_1900;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * 最高频元素的频数
 * <p>
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * Created by zhangtao552 on 2021/7/19.
 */
public class Solution1838 implements Solution {


    /**
     * 滑动窗口
     *
     * @param nums [1, 10^5]
     * @param k    [1, 10^5]
     * @return 最大可能频数
     */
    @SolutionEntry
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, window = 0;
        Arrays.sort(nums);
        while (right < n) {
            int max = nums[right];
            int count = right - left + 1;
            window += nums[right];
            right++;
            if (max * count - window > k) {
                window -= nums[left];
                left++;
            }
        }
        return right - left;
    }

    @Test
    @Override
    public void test() {
        solute(new int[]{1, 2, 4}, 5);
    }
}
