package com.kingsley.leetcode.solution.leet.No400_500;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Class Solution447
 * @Time 2021/9/13 下午12:28
 * @Author kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/number-of-boomerangs/">447. 回旋镖的数量</a>
 */
public class Solution447 implements Solution {

    @Test
    @Override
    public void test() {
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        solute(points);
    }

    @SolutionEntry
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return 0;
        }
        int result = 0;
        for (int[] p1 : points) {
            HashMap<Long, Integer> map = new HashMap<>();
            for (int[] p2 : points) {
                long distance = getDistance(p1, p2);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int cnt : map.values()) {
                result += cnt * (cnt - 1);
            }
        }
        return result;
    }

    private long getDistance(int[] p1, int[] p2) {
        int x = p2[0] - p1[0];
        int y = p2[1] - p1[1];
        return (long) x * x + (long) y * y;
    }
}
