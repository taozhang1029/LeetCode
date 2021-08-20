package com.kingsley.leetcode.solution.leet.No500_600;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/20 21:42
 * @description
 * @see <a href="https://leetcode-cn.com/problems/reverse-string-ii/">541. 反转字符串 II</a>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class Solution541 implements Solution {

    @Test
    @Override
    public void test() {
        solute("abcdefg", 2); // bacdfeg
    }

    @SolutionEntry
    public String reverseStr(String s, int k) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        while (true) {
            // TODO
            if ((curr / k) % 2 == 0) {
                // 前k个
                for (int i = curr + k - 1; i >= curr; i--) {
                    sb.append(array[i]);
                }
            } else {

            }
            if (curr >= k) {
                break;
            }
            curr += k;
        }
        return sb.toString();
    }

}
