package com.kingsley.leetcode.solution.leet.No1201_1300;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/7 11:18
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/">分割平衡字符串</a>
 */
public class Solution1221 extends Solution {

    @Test
    @Override
    public void test() {
        solute("RLLLLRRRLR");
    }

    @SolutionEntry
    public int balancedStringSplit(String s) {
        int p = 0;
        int n = s.length();
        int L = 0, R = 0;
        int result = 0;
        while (p < n) {
            char c = s.charAt(p);
            if (c == 'L') {
                L++;
            } else {
                R++;
            }
            if (L == R) {
                result++;
                L = 0;
                R = 0;
            }
            p++;
        }
        return result;
    }
}
