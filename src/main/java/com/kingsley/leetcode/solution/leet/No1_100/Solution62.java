package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.type.DynamicProgramming;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/11 13:37
 * @Author Kingsley
 * @Project LeetCode
 * @Description 动态规划
 * @see <a href="https://leetcode-cn.com/problems/unique-paths/">62. 不同路径</a>
 */
public class Solution62 extends Solution implements DynamicProgramming{

    @Test
    @Override
    public void test() {
        solute(3, 7);
    }

    @SolutionEntry
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        nums[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    nums[i][j] = nums[i][j - 1];
                }
                if (j == 0) {
                    nums[i][j] = nums[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[m - 1][n - 1];
    }

}
