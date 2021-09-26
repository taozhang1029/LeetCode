package com.kingsley.leetcode.solution.leet.No1801_1900;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Time 2021/9/10 9:48
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/">1894. 找到需要补充粉笔的学生编号</a>
 */
public class Solution1894 extends Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{3, 4, 1, 2}, 25);
    }

    @SolutionEntry
    public int chalkReplacer(int[] chalk, int k) {
        long sum = Arrays.stream(chalk).mapToLong(Long::valueOf).sum();
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }

}
