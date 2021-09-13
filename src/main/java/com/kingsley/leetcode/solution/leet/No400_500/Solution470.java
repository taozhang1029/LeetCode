package com.kingsley.leetcode.solution.leet.No400_500;

import com.kingsley.leetcode.api.SolBase;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/5 11:29
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/">470. 用 Rand7() 实现 Rand10()</a>
 */
public class Solution470 extends SolBase implements Solution {

    @Test
    @Override
    public void test() {
        solute();
    }

    @SolutionEntry
    public int rand10() {
        int idx;
        do {
            int num1 = rand7();
            int num2 = rand7();
            idx = num1 * (num2 - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }
}
