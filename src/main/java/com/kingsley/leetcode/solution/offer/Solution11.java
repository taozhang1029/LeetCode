package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

/**
 * 剑指 Offer 11. 旋转数组的最小数字 https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * Created by zhangtao552 on 2021/7/21.
 */
public class Solution11 extends Solution {

    @Test
    @Override
    public void test() {
        int[] numbers = {3, 4, 5, 1, 2};
        solute((Object) numbers);
    }

    @SolutionEntry
    public int minArray(int[] numbers) {
        int left = numbers[0];
        for (int number : numbers) {
            if (left > number) {
                return number;
            }
        }
        return left;
    }
}
