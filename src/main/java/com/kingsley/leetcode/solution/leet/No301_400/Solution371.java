package com.kingsley.leetcode.solution.leet.No301_400;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import com.kingsley.leetcode.type.MathType;
import org.junit.Test;

/**
 * @Class Solution371
 * @Time 2021/9/26 上午10:50
 * @Author kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/sum-of-two-integers/">371. 两整数之和</a>
 */
@SolutionInfo(value = "两整数之和", requirements = "不使用 运算符 + 和 - 计算并返回两整数之和。")
public class Solution371 extends Solution implements MathType {

    @Test
    @Override
    public void test() {
        solute(3, 9);
    }

    @SolutionEntry
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // 所有需要进位的bit
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
