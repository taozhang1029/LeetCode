package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.type.DynamicProgramming;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time 2021/9/7 16:28
 * @Author Kingsley
 * @Project LeetCode
 * @Description 动态规划
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">22. 括号生成</a>
 */
public class Solution22 extends Solution implements DynamicProgramming {

    @Test
    @Override
    public void test() {
        solute(3);
    }

    @SolutionEntry
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
