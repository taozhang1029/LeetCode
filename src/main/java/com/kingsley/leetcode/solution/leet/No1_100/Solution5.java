package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.type.DynamicProgramming;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/7 12:18
 * @Author Kingsley
 * @Project LeetCode
 * @Description 动态规划
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 */
public class Solution5 implements DynamicProgramming {

    @Test
    @Override
    public void test() {
        solute("babad");
    }

    @SolutionEntry
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int max = 1;
        int left = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        // 先枚举子串长度
        for (int len = 2; len <= n; len++) {
            // 由 len 和 i 可以确定右边界，即 j - i + 1 = len 得
            for (int i = 0; i < n; i++) {
                // 右边界
                int j = i + len - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= n) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // dp[i][j] == true 表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    left = i;
                }
            }
        }
        return s.substring(left, left + max);
    }

}
