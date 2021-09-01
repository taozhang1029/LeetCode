package com.kingsley.leetcode.solution.leet.No101_200;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/1 15:21
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/compare-version-numbers/">165. 比较版本号</a>
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
 * 修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 */
public class Solution165 implements Solution {

    @Test
    @Override
    public void test() {
        solute("1.01", "1.001");
        solute("1.0", "1.0.0");
        solute("0.1", "1.1");
        solute("1.0.1", "1");
        solute("7.5.2.4", "7.5.3");
    }

    @SolutionEntry
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");
        int idx = 0;
        while (idx < versions1.length || idx < versions2.length) {
            int v1 = 0, v2 = 0;
            if (idx < versions1.length) {
                v1 = Integer.parseInt(versions1[idx]);
            }
            if (idx < versions2.length) {
                v2 = Integer.parseInt(versions2[idx]);
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            idx++;
        }
        return 0;
    }
}
