package com.kingsley.leetcode.solution.leet.No500_600;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @author: zhangtao552
 * @time: 2021/8/17 10:41
 * @description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/student-attendance-record-i/">551. 学生出勤记录 I</a>
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 1. 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 2. 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 */
public class Solution551 implements Solution {
    @Test
    @Override
    public void test() {
        solute("PPALLP");
        solute("PPALLL");
    }

    @SolutionEntry
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;
        int lastLate = -1;
        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (absent >= 2 || late >= 3) {
                break;
            }
            if (c == 'A') {
                absent++;
            } else if (c == 'L') {
                if (i == lastLate + 1) {
                    late++;
                } else {
                    late = 1;
                }
                lastLate = i;
            }
        }
        return absent < 2 && late < 3;
    }
}
