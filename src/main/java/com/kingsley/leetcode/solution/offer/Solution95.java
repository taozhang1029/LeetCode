package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.solution.leet.No1100_1200.Solution1143;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/13 16:14
 * @description 最长公共子序列
 * @see <a href="https://leetcode-cn.com/problems/qJnOS7/">剑指 Offer II 095. 最长公共子序列</a>
 * {@link com.kingsley.leetcode.solution.leet.No1100_1200.Solution1143}
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 * 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Solution95 implements Solution {
    @Test
    @Override
    public void test() {

    }

    @SolutionEntry
    public int longestCommonSubsequence(String text1, String text2) {
        return new Solution1143().longestCommonSubsequence(text1, text2);
    }
}
