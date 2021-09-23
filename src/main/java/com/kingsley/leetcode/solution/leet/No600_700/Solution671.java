package com.kingsley.leetcode.solution.leet.No600_700;

import com.kingsley.leetcode.api.TreeNode;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zhangtao552
 * @time: 2021/7/27 12:55
 * @description 2021/7/27 每日一题
 * @see <a href="https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/">671. 二叉树中第二小的节点</a>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 2^31 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 */
public class Solution671 extends Solution {

    private PriorityQueue<Integer> queue;

    private int min1, min2 = -1;

    @Test
    @Override
    public void test() {
        solute(TreeNode.builder().val(2)
            .left(TreeNode.builder().val(2).build())
            .right(TreeNode.builder().val(5)
                .left(TreeNode.builder().val(5).build())
                .right(TreeNode.builder().val(7).build())
                .build())
            .build()
        );
    }

    @SolutionEntry
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        min1 = root.val;
        queue = new PriorityQueue<>();
        queue.add(root.val);
        find(root);
        if (queue.size() < 2) {
            return -1;
        }
        min1 = queue.poll();
        while (!queue.isEmpty() && queue.peek() == min1) {
            queue.poll();
        }

        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void find(TreeNode root) {
        if (root == null || root.left == null) {
            return;
        }
        int left = root.left.val;
        int right = root.right.val;
        if (min2 == -1) {
            min1 = Math.min(left, right);
            min2 = Math.max(left, right);
        } else {
            int[] nums = {min1, min2, left, right};
            Arrays.sort(nums);
            min1 = nums[0];
            min2 = nums[1];
        }
        queue.add(left);
        queue.add(right);
        if (left < min2) {
            find(root.left);
        }
        if (right < min2) {
            find(root.right);
        }
    }
}
