package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import com.kingsley.leetcode.type.MathType;
import org.junit.Test;

/**
 * @Time 2021/10/21 12:38
 * @Author Kingsley
 * @Project LeetCode
 * @Description meiriyiti
 * @see <a href="https://leetcode-cn.com/problems/plus-one/">66. 加一</a>
 */
@SolutionInfo("66. 加一")
public class Solution66 extends Solution implements MathType {

    @Test
    @Override
    public void test() {
        checkResult(new int[]{1, 2, 4}, new int[]{1, 2, 3});
        checkResult(new int[]{4, 3, 2, 2}, new int[]{4, 3, 2, 1});
        checkResult(new int[]{1}, new int[]{0});
        checkResult(new int[]{1,0,0,0,0}, new int[]{9,9,9,9});
    }

    @SolutionEntry
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean flag = false;
        if (digits[n - 1] == 9) {
            flag = true;
            digits[n - 1] = 0;
        } else {
            digits[n - 1] += 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (flag) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    flag = false;
                }
            } else {
                break;
            }
        }
        if (flag) {
            int[] result = new int[n + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        }
        return digits;
    }
}
