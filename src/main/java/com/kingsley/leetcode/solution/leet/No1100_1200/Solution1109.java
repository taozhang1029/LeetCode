package com.kingsley.leetcode.solution.leet.No1100_1200;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/8/31 17:07
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/corporate-flight-bookings/">1109. 航班预订统计</a>
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi]
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <img src="../../../../../../../resources/image/leet1109.png"/>
 */
public class Solution1109 implements Solution {

    @Test
    @Override
    public void test() {
        solute(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    @SolutionEntry
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int cnt = booking[2];
            for (int i = start - 1; i < end; i++) {
                result[i] += cnt;
            }
        }
        return result;
    }

}
