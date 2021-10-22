package com.kingsley.leetcode.solution.leet.No401_500;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import com.kingsley.leetcode.type.MathType;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Time 2021/10/21 12:28
 * @Author Kingsley
 * @Project LeetCode
 * @Description 453. 最小操作次数使数组元素相等
 * @see <a href="https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/">453. 最小操作次数使数组元素相等</a>
 */
@SolutionInfo("453. 最小操作次数使数组元素相等")
public class Solution453 extends Solution implements MathType {

    @Test
    @Override
    public void test() {
        checkResult(3, new int[]{1, 2, 3});
        checkResult(0, new int[]{1, 1, 1});
    }

    @SolutionEntry
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        return Arrays.stream(nums).map(num -> num - min).sum();
    }

}
