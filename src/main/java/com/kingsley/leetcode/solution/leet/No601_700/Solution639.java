package com.kingsley.leetcode.solution.leet.No601_700;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import com.kingsley.leetcode.type.algorithm.DynamicProgramming;
import org.junit.Test;

/**
 * @Class Solution639
 * @Time 2021/9/27 下午10:19
 * @Author kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/decode-ways-ii/">639. 解码方法 II</a>
 */
@SolutionInfo("解码方法 II")
public class Solution639 extends Solution implements DynamicProgramming {

    private final int MOD = 1000000007;

    @SolutionEntry(countTime = true)
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }

    @Test
    @Override
    public void test() {
        checkResult(9, "*");
        checkResult(18, "1*");
        checkResult(15, "2*");
        checkResult(9, "3*");
        checkResult(96, "**");
        checkResult(11, "*1");
        checkResult(11, "*3");
        checkResult(9, "3*");
    }

}
