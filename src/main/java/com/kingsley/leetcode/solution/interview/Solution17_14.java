package com.kingsley.leetcode.solution.interview;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Time 2021/9/3 15:37
 * @Author Kingsley
 * @Project LeetCode
 * @Description 【每日一题】
 * @see <a href="https://leetcode-cn.com/problems/smallest-k-lcci/">面试题 17.14. 最小K个数</a>
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 */
public class Solution17_14 extends Solution {

    @Test
    @Override
    public void test() {
        solute(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }

    @SolutionEntry
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.stream().mapToInt(Integer::valueOf).toArray();
    }
}
