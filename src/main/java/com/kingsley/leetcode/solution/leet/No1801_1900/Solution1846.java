package com.kingsley.leetcode.solution.leet.No1801_1900;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素
 * <p>
 * Created by zhangtao1029 on 2021/7/15.
 */
public class Solution1846 extends Solution {

    @SolutionEntry
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; ++i) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }

    @Test
    public void test() {
        solute(new int[]{123});
    }
}
