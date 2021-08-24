package com.kingsley.leetcode.solution.leet.No1700_1800;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangtao552
 * @time: 2021/7/26 13:06
 * @description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/">1713. 得到子序列的最少操作次数</a>
 * 给你一个数组target，包含若干互不相同的整数，以及另一个整数数组arr，arr可能包含重复元素。
 * 每一次操作中，你可以在arr的任意位置插入任一整数。比方说，如果arr = [1,4,1,2]，那么你可以在中间添加3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。
 * 请你返回 最少操作次数，使得target成为arr的一个子序列。
 * 一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。
 * 比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。
 */
public class Solution1713 implements Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1});
    }

    /**
     * 1 <= target.length, arr.length <= 10^5
     * 1 <= target[i], arr[i] <= 10^9
     * target不包含任何重复元素
     */
    @SolutionEntry
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = binarySearch(d, idx);
                if (it != d.size()) {
                    d.set(it, idx);
                } else {
                    d.add(idx);
                }
            }
        }
        return n - d.size();
    }

    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
