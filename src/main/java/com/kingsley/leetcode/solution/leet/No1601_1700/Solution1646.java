package com.kingsley.leetcode.solution.leet.No1601_1700;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/23 12:53
 * @description
 * @see <a href="https://leetcode-cn.com/problems/get-maximum-in-generated-array/">1646. 获取生成数组中的最大值</a>
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * @see <p>
 * <strong>输入：</strong>n = 7
 * </p>
 * <p>
 * <strong>输出：</strong>3
 * </p>
 * <p>
 * <strong>解释：</strong>
 * </p>
 * <p>
 * 根据规则：
 * </p>
 * <p>
 * nums[0] = 0
 * </p>
 * <p>
 * nums[1] = 1
 * </p>
 * <p>
 * nums[(1 * 2) = 2] = nums[1] = 1
 * </p>
 * <p>
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * </p>
 * <p>
 * nums[(2 * 2) = 4] = nums[2] = 1
 * </p>
 * <p>
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * </p>
 * <p>
 * nums[(3 * 2) = 6] = nums[3] = 2
 * </p>
 * <p>
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * </p>
 * <p>
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * </p>
 */
public class Solution1646 extends Solution {

    private int[] mem;

    @Test
    @Override
    public void test() {
        solute(2);
    }

    /**
     * 0 <= n <= 100
     */
    @SolutionEntry(countTime = true)
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int cnt;
        if (n % 2 == 0) {
            cnt = n / 2;
        } else {
            cnt = n / 2 + 1;
        }
        mem = new int[cnt + 1];
        mem[1] = 1;
        for (int i = cnt; i >= 2; i--) {
            fill(i);
        }
        int result = 0;
        for (int i = 0; i < cnt; i++) {
            result = Math.max(result, mem[i] + mem[i + 1]);
        }
        return result;
    }

    private void fill(int idx) {
        if (idx < 2 || mem[idx] != 0) {
            return;
        }
        if (idx % 2 == 0) {
            fill(idx / 2);
            mem[idx] = mem[idx / 2];
        } else {
            fill((idx - 1) / 2);
            fill((idx - 1) / 2 + 1);
            mem[idx] = mem[(idx - 1) / 2] + mem[(idx - 1) / 2 + 1];
        }
    }
}
