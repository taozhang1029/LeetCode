package com.kingsley.leetcode.solution.offer.medium;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer 12. 矩阵中的路径 https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * Created by zhangtao552 on 2021/7/22.
 */
public class Solution12 implements Solution {

    @Test
    @Override
    public void test() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        solute(board, word);

        char[][] board2 = {{'A', 'B'}, {'C', 'D'}};
        String word2 = "ABCD";
        solute(board2, word2);
    }

    @SolutionEntry
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    for (boolean[] v : visited) {
                        Arrays.fill(v, false);
                    }
                    visited[i][j] = true;
                    if (backtrack(board, visited, word, 1, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
        if (idx == word.length()) {
            return true;
        }
        char c = word.charAt(idx);
        // 往上走
        int row = i - 1;
        int col = j;
        if (isValid(board, visited, c, row, col)) {
            visited[row][col] = true;
            if (backtrack(board, visited, word, idx + 1, row, col)) {
                return true;
            }
            visited[row][col] = false;
        }
        // 往下走
        row = i + 1;
        col = j;
        if (isValid(board, visited, c, row, col)) {
            visited[row][col] = true;
            if (backtrack(board, visited, word, idx + 1, row, col)) {
                return true;
            }
            visited[row][col] = false;
        }
        // 往左走
        row = i;
        col = j - 1;
        if (isValid(board, visited, c, row, col)) {
            visited[row][col] = true;
            if (backtrack(board, visited, word, idx + 1, row, col)) {
                return true;
            }
            visited[row][col] = false;
        }
        // 往右走
        row = i;
        col = j + 1;
        if (isValid(board, visited, c, row, col)) {
            visited[row][col] = true;
            if (backtrack(board, visited, word, idx + 1, row, col)) {
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }

    private boolean isValid(char[][] board, boolean[][] visited, char c, int row, int col) {
        if (row < 0 || row >= visited.length) {
            return false;
        }
        if (col < 0 || col >= visited[0].length) {
            return false;
        }

        return !visited[row][col] && board[row][col] == c;
    }
}
