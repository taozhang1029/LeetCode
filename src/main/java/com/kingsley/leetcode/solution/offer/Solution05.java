package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @see <a href="https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/">剑指Offer 05.替换空格</a>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * Created by zhangtao552 on 2021/7/23.
 */
public class Solution05 implements Solution {

    @Test
    @Override
    public void test() {
        solute("we are happy");
    }

    @SolutionEntry
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
