package com.kingsley.leetcode.solution.leet.No101_200;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/7/30 13:37
 * @description 每日一题
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 1 <= columnTitle.length <= 7
 * columnTitle 仅由大写英文组成
 * columnTitle 在范围 ["A", "FXSHRXW"] 内
 * @see <a href="https://leetcode-cn.com/problems/excel-sheet-column-number/">171. Excel表列序号</a>
 */
public class Solution171 implements Solution {

    @Test
    @Override
    public void test() {
        solute("ZY");
        solute("FXSHRXW");
    }

    @SolutionEntry
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] array = columnTitle.toCharArray();
        int n = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int bit = n - i;
            result += getValue(array[i]) * Math.pow(26, bit);
        }
        return result;
    }

    private int getValue(char c) {
        return c - 'A' + 1;
    }
}
