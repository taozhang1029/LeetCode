package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.Solution;
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
        int maxMul = 1;
        for (int cnt = 2; cnt <= n; cnt++) {
            int mul;
            if (n % cnt != 0) {
                int length;
                int intL = cnt / n;
                double doubleL = cnt * 1.0 / n;
                if (doubleL >= intL + 0.5) {
                    length = intL + 1;
                } else {
                    length = intL;
                }
                mul = (int) (Math.pow(length, cnt - 1) * (n - (cnt - 1) * length));
                log.info("cnt = {}, length = {}", cnt, length);
            } else {
                mul = (int) Math.pow(n / cnt, cnt);
            }
            log.info(String.valueOf(mul));
            maxMul = Math.max(maxMul, mul);
        }
        return maxMul;
    }
}
