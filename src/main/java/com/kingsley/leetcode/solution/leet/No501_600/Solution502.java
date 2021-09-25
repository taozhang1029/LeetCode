package com.kingsley.leetcode.solution.leet.No501_600;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Time 2021/9/10 10:02
 * @Author Kingsley
 * @Project LeetCode
 * @Description 502. IPO
 * @see <a href="https://leetcode-cn.com/problems/ipo/">502. IPO</a>
 */
public class Solution502 extends Solution {

    private int result;

    @Test
    @Override
    public void test() {
        // 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
        // 输出：4
        solute(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
        // 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
        // 输出：6
        solute(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
    }

    @SolutionEntry
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] capProfit = new int[n][2];

        for (int i = 0; i < n; ++i) {
            capProfit[i][0] = capital[i];
            capProfit[i][1] = profits[i];
        }
        // 按照所需的最小资本排序
        Arrays.sort(capProfit, Comparator.comparingInt(a -> a[0]));
        // 利润降序的优先队列（实际存储着使用最小资本所能获得的最大利润）
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            // 还可以投资，并且当前资本支持这个项目
            while (curr < n && capProfit[curr][0] <= w) {
                queue.add(capProfit[curr][1]);
                curr++;
            }
            if (!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
        }

        return w;
    }
}
