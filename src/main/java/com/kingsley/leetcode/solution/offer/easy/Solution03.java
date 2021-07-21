package com.kingsley.leetcode.solution.offer.easy;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 2 <= n <= 100000
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * Created by zhangtao552 on 2021/7/21.
 */
@Slf4j
public class Solution03 implements Solution {

    @SolutionEntry
    public int findRepeatNumber(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        HashSet<Integer> set = new HashSet<>();
        while (p <= q) {
            int n1 = nums[p];
            if (p == q) {
                return n1;
            } else {
                if (set.contains(n1)) {
                    return n1;
                }
                set.add(n1);
                int n2 = nums[q];
                if (set.contains(n2)) {
                    return n2;
                }
                set.add(n2);
            }
            p++;
            q--;
        }
        return -1;
    }

    @Test
    @Override
    public void test() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        solute((Object) nums);
    }
}
