package com.kingsley.leetcode.solution.leet.No600_700;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Time 2021/9/12 14:16
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/valid-parenthesis-string/">678. 有效的括号字符串</a>
 */
public class Solution678 implements Solution {

    @Test
    @Override
    public void test() {
        solute("(((((*(((((*((**(((()()*)()()()*((((**))*)*)))))))))((*(((((**(**)");
    }

    @SolutionEntry(priority = 1)
    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (left.isEmpty()) {
                    if (star.isEmpty()) {
                        return false;
                    }
                    star.poll();
                } else {
                    left.poll();
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            int idx1 = left.poll();
            int idx2 = star.poll();
            if (idx1 > idx2) {
                return false;
            }
        }

        return left.isEmpty();
    }

    @SolutionEntry
    private boolean bestSolution(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}
