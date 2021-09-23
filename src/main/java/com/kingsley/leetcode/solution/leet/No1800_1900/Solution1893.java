package com.kingsley.leetcode.solution.leet.No1800_1900;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 2021/7/23每日一题
 *
 * @see <a href="https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/">1893. 检查是否区域内所有整数都被覆盖</a>
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * Created by zhangtao552 on 2021/7/23.
 */
public class Solution1893 extends Solution {

    @Test
    @Override
    public void test() {
        int[][] ranges1 = {{1, 2}, {3, 4}, {5, 6}};
        int left1 = 2;
        int right1 = 5;
        solute(ranges1, left1, right1);
        int[][] ranges2 = {{1, 10}, {10, 20}};
        int left2 = 21;
        int right2 = 21;
        solute(ranges2, left2, right2);
    }

    @SolutionEntry
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        LinkedList<int[]> intervals = new LinkedList<>();
        intervals.add(ranges[0]);

        for (int i = 1; i < ranges.length; i++) {
            int[] curr = ranges[i];
            int[] last = intervals.removeLast();
            if (curr[1] < last[1]) {
                intervals.add(last);
            } else {
                if (last[1] >= curr[0] - 1) {
                    intervals.add(new int[]{last[0], curr[1]});
                } else {
                    intervals.add(last);
                    intervals.add(curr);
                }
            }
        }

        for (int[] interval : intervals) {
            if (left >= interval[0] && right <= interval[1]) {
                return true;
            }
        }

        return false;
    }
}
