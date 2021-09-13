package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/7/30 13:54
 * @description offer 13
 * @see <a href="https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">剑指 Offer 13. 机器人的运动范围</a>
 * <img src="../../../../../../resources/image/offer13.png"/>
 */
@Slf4j
public class Solution13 implements Solution {

    private int grids = 0;

    @Test
    @Override
    public void test() {
        solute(100, 100, 20);
    }

    @SolutionEntry(countTime = true)
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0, k, m, n, visited);
        return grids;
    }

    private void dfs(int i, int j, int k, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0) {
            return;
        }
        if (i >= m || j >= n) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int result = 0;
        int tmp = i;
        while (tmp > 0) {
            result += (tmp % 10);
            tmp /= 10;
            if (result > k) {
                return;
            }
        }
        tmp = j;
        while (tmp > 0) {
            result += (tmp % 10);
            tmp /= 10;
            if (result > k) {
                return;
            }
        }
        grids++;
        // dfs(i - 1, j, k, m, n, visited);
        // dfs(i, j - 1, k, m, n, visited);
        dfs(i + 1, j, k, m, n, visited);
        dfs(i, j + 1, k, m, n, visited);
    }
}
