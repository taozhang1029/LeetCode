package com.kingsley.leetcode.solution.leet.No501_600;

import com.kingsley.leetcode.type.algorithm.DynamicProgramming;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

/**
 * @Time 2021/9/25 10:06
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/delete-operation-for-two-strings/">583. 两个字符串的删除操作</a>
 */
@SolutionInfo("两个字符串的删除操作")
public class Solution583 extends Solution implements DynamicProgramming {

    @Test
    @Override
    public void test() {
        solute("sea", "eat");
    }

    @SolutionEntry
    public int minDistance(String word1, String word2) {
        final int n1 = word1.length();
        final int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            final char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                final char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n1 + n2 - 2 * dp[n1][n2];
    }
}
