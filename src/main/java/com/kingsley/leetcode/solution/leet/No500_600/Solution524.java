package com.kingsley.leetcode.solution.leet.No500_600;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import com.kingsley.leetcode.util.SolutionInfo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Time 2021/9/14 12:23
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/">524. 通过删除字母匹配到字典里最长单词</a>
 */
@SolutionInfo(solutionName = "通过删除字母匹配到字典里最长单词")
public class Solution524 extends Solution {

    @Test
    @Override
    public void test() {
        solute("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
    }

    @SolutionEntry
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s2.length(), s1.length());
            } else {
                return s1.compareTo(s2);
            }
        });
        for (String target : dictionary) {
            if (isValid(s, target)) {
                return target;
            }
        }
        return "";
    }

    private boolean isValid(String src, String target) {
        char[] chars1 = src.toCharArray();
        char[] chars2 = target.toCharArray();
        int curr = 0;
        for (char c : chars1) {
            if (c == chars2[curr]) {
                curr++;
            }
            if (curr == chars2.length) {
                return true;
            }
        }
        return false;
    }
}
