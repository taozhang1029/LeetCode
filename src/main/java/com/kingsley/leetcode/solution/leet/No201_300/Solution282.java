package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.type.algorithm.Backtrack;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time 2021/10/16 13:55
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/expression-add-operators/">282. 给表达式添加运算符</a>
 */
@SolutionInfo(solutionName = "282. 给表达式添加运算符")
public class Solution282 extends Solution implements Backtrack {

    private final char[] ops = {'+', '-', '*'};
    private String num;
    private int target;
    private List<String> list;

    @SolutionEntry
    public List<String> addOperators(String num, int target) {
        list = new LinkedList<>();
        this.num = num;
        this.target = target;
        StringBuilder sb = new StringBuilder();
        sb.append(num.charAt(0));
        backtrack(1, num.length(), sb);
        return list;
    }

    private void backtrack(int idx, int n, StringBuilder sb) {
        if (idx == n) {
            String s = sb.toString();
            if (!list.contains(s) && isValid(s)) {
                list.add(s);
            }
            return;
        }
        int tmpN = sb.length();
        int tmp = 0;
        for (int i = tmpN - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (Character.isDigit(c)) {
                tmp += c - '0';
            } else {
                break;
            }
            if (tmp != 0) {
                break;
            }
        }

        if (tmp != 0) {
            sb.append(num.charAt(idx));
            backtrack(idx + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        for (char op : ops) {
            sb.append(op).append(num.charAt(idx));
            backtrack(idx + 1, n, sb);
            sb.delete(sb.length() - 2, sb.length());
        }
    }

    private boolean isValid(String expression) {
        Deque<Long> stack = new LinkedList<>();
        long sign = 1;
        long pre = 0;
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
            } else {
                if (sign == 0) {
                    // 乘法
                    stack.push(stack.poll() * pre);
                } else {
                    stack.push(sign * pre);
                }
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } else {
                    sign = 0;
                }
                pre = 0;
            }
        }
        if (sign == 0) {
            stack.push(stack.poll() * pre);
        } else {
            stack.push(sign * pre);
        }
        long result = 0;
        for (long a : stack) {
            result += a;
        }
        return result == (target);
    }

    @Test
    @Override
    public void test() {
        solute("2147483648", -2147483648);
    }
}
