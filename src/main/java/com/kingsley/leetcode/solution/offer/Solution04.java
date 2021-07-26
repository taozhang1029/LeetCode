package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * 二维数组中的查找 https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * Created by zhangtao552 on 2021/7/21.
 */
public class Solution04 implements Solution {

    @Test
    @Override
    public void test() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        solute(matrix, 9);
        solute(matrix, 99);
        solute(matrix, 1);
    }

    @SolutionEntry
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int r = matrix.length;
        if (r == 0 || matrix[0].length == 0) {
            return false;
        }
        r--;
        int c = 0;
        while (r >= 0) {
            if (matrix[r][c] > target) {
                r--;
            } else if (matrix[r][c] < target) {
                if (c < matrix[0].length - 1) {
                    c++;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        return false;
    }
}
