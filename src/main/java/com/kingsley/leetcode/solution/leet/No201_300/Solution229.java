package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.type.MathType;
import org.junit.Test;

import java.util.*;

/**
 * @Time 2021/10/22 14:19
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/majority-element-ii/">229. 求众数 II</a>
 */
public class Solution229 extends Solution implements MathType {

    @Test
    @Override
    public void test() {
        solute(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
    }

    @SolutionEntry
    public List<Integer> majorityElement(int[] nums) {
        int c = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach((a -> map.put(a, map.getOrDefault(a, 0) + 1)));
        List<Integer> result = new LinkedList<>();
        map.forEach((a, cnt) -> {
            if (cnt > c) {
                result.add(a);
            }
        });
        return result;
    }
}
