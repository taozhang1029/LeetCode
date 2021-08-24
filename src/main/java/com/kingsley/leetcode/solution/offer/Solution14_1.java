package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/7/30 15:39
 * @description offer14
 * @see <a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof/">剑指 Offer 14- I. 剪绳子</a>
 * <img src="../../../../../../resources/image/offer14_1.png" alt="路径错误"/>
 */
@Slf4j
public class Solution14_1 implements Solution {

    @Test
    @Override
    public void test() {
        solute(10);// 36
        solute(3);// 2
        solute(2);// 1
        solute(8);// 18
    }

    @SolutionEntry
    public int cuttingRope(int n) {
        return n <= 3 ? n - 1 : (int) (Math.pow(3, n / 3) * 4 / (4 - n % 3));
    }
}
