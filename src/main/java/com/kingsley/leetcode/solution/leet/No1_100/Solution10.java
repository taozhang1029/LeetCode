package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.type.DynamicProgramming;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

/**
 * @Time 2021/9/7 15:40
 * @Author Kingsley
 * @Project LeetCode
 * @Description 动态规划
 * <a href="https://leetcode-cn.com/problems/regular-expression-matching/">10. 正则表达式匹配</a>
 */

@SolutionInfo("正则表达式匹配")
public class Solution10 extends Solution implements DynamicProgramming {

    @Test
    @Override
    public void test() {
        solute("aab", "c*a*b*");
    }

    @SolutionEntry
    public boolean isMatch(String s, String p) {
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[0][0] = true;
        for (int col = 1; col < table[0].length; col++) {
            char ch = p.charAt(col - 1);
            if (col > 1) {
                if (ch == '*') {
                    table[0][col] = table[0][col - 2];
                } else {
                    table[0][col] = false;
                }
            } else {
                if (ch == '*') {
                    table[0][col] = true;
                }
            }
        }
        for (int row = 1; row < table.length; row++) {
            char ch1 = s.charAt(row - 1);
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = p.charAt(col - 1);
                if (ch1 == ch2 || ch2 == '.') {
                    table[row][col] = table[row - 1][col - 1];
                } else if (ch2 == '*') {
                    if (col > 1) {
                        if (table[row][col - 2]) {
                            table[row][col] = true; // * 前面的字符出现0次
                        } else {
                            char prev = p.charAt(col - 2);
                            if (prev == ch1 || prev == '.') {
                                table[row][col] = table[row - 1][col]; // * 前面的字符出现多次
                            }
                        }
                    }
                }
            }
        }
        boolean[] lastRow = table[table.length - 1];
        return lastRow[lastRow.length - 1];
    }

}
