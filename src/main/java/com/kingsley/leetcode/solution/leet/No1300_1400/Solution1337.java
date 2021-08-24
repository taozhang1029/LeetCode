package com.kingsley.leetcode.solution.leet.No1300_1400;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.Data;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author: zhangtao552
 * @time: 2021/8/2 9:36
 * @description 2021/8/1 每日一题
 * @see <a href="https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/">1337. 矩阵中战斗力最弱的 K 行</a>
 * 给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 */
public class Solution1337 implements Solution {

    @Test
    @Override
    public void test() {
        int[][] mat = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        solute(mat, 3);
    }

    @SolutionEntry
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Unit> queue = new PriorityQueue<>(k);
        for (int i = 0; i < mat.length; i++) {
            queue.add(new Unit(i, findLastOne(mat[i])));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().index;
        }
        return result;
    }

    private int findLastOne(int[] row) {
        int p = 0;
        int q = row.length;
        while (p < q) {
            int mid = p + (q - p) / 2;
            if (row[mid] == 0) {
                q--;
            } else {
                p++;
            }
        }
        return p;
    }

    @Data
    private static class Unit implements Comparable<Unit> {

        Integer index;

        Integer strength;

        public Unit(Integer index, Integer strength) {
            this.index = index;
            this.strength = strength;
        }

        @Override
        public int compareTo(Unit unit) {
            if (this.strength.equals(unit.strength)) {
                return this.index.compareTo(unit.index);
            } else {
                return this.strength.compareTo(unit.strength);
            }
        }
    }
}
