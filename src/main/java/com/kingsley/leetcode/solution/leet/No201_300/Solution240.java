package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/13 15:22
 * @description
 * @see <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">240. 搜索二维矩阵 II</a>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matix[i][j] <= 10^9
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -10^9 <= target <= 10^9
 */
public class Solution240 extends Solution {

    @Test
    @Override
    public void test() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        solute(matrix, target);
    }

    @SolutionEntry
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix[0].length;
        int i = matrix.length - 1;
        int j = 0;
        while (true) {
            if (i < 0) {
                return false;
            }
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                if (j < N - 1) {
                    j++;
                } else {
                    i--;
                }
            }
        }
    }
}
