package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/13 15:50
 * @description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/number-of-digit-one/">233. 数字 1 的个数</a>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 0 <= n <= 2 * 10^9
 */
public class Solution233 extends Solution {

    @Test
    @Override
    public void test() {
        solute(13);// 6
    }

    @SolutionEntry
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        while (n >= mulk) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
