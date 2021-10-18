package com.kingsley.leetcode.solution.leet.No401_500;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import com.kingsley.leetcode.type.MathType;
import org.junit.Test;

/**
 * @Time 2021/10/18 10:26
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题‘
 * @see <a href="https://leetcode-cn.com/problems/number-complement/">476. 数字的补数</a>
 */
@SolutionInfo("476. 数字的补数")
public class Solution476 extends Solution implements MathType {

    /**
     * num >= 1
     */
    @SolutionEntry
    public int findComplement(int num) {
        boolean flag = false;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (flag) {
                result += ((1-bit) << i);
            } else if (bit != 0) {
                flag = true;
            }
        }
        return result;
    }

    @Test
    @Override
    public void test() {
        checkResult(2,5);
        checkResult(0,7);
        checkResult(5,10);
        checkResult(0,1);
    }
}
