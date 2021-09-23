package com.kingsley.leetcode.solution.leet.No600_700;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/11 12:00
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/">600. 不含连续1的非负整数</a>
 */
public class Solution600 extends Solution {

    private int result = 1;

    @Test
    @Override
    public void test() {
        solute(5);
    }

    @SolutionEntry
    public int findIntegers(int n) {
        // 超时
        // return mySolution(n);
        dfs(n, 1);
        return result;
    }

    private void dfs(int max, int curr) {
        if (curr > max) {
            return;
        }
        result++;
        // 末尾加0
        dfs(max, curr << 1);
        // 当前以0结尾，则可以补1
        if ((curr & 1) == 0) {
            dfs(max, (curr << 1) + 1);
        }
    }


    /**
     * 超时
     */
    private int mySolution(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (isValid(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean isValid(int n) {
        int last = -1;
        while (n != 0) {
            int tmp = n % 2;
            if (tmp == 1 && tmp == last) {
                return false;
            }
            last = tmp;
            n >>= 1;
        }
        return true;
    }
}
