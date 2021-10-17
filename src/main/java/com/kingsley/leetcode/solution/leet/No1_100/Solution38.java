package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

/**
 * @Time 2021/10/15 13:11
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/count-and-say/">38. 外观数列</a>
 */
@SolutionInfo(value = "38. 外观数列")
public class Solution38 extends Solution {

    @Test
    @Override
    public void test() {
        solute(5);
    }

    @SolutionEntry
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String currStr = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char preChar = currStr.charAt(0);
            int cnt = 1;
            char[] charArray = currStr.toCharArray();
            for (int j = 1; j < charArray.length; j++) {
                char c = charArray[j];
                if (c == preChar) {
                    cnt++;
                } else {
                    sb.append(cnt).append(preChar - '0');
                    preChar = c;
                    cnt = 1;
                }
            }
            sb.append(cnt).append(preChar - '0');
            currStr = sb.toString();
            System.out.println(currStr);
        }
        return currStr;
    }

}
