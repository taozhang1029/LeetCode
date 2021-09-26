package com.kingsley.leetcode.solution.leet.No401_500;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.Random;

/**
 * @Time 2021/9/5 11:29
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/implement-rand10-using-rand7/">470. 用 Rand7() 实现 Rand10()</a>
 */
public class Solution470 extends Solution {

    @Test
    @Override
    public void test() {
        solute();
    }

    public int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
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
