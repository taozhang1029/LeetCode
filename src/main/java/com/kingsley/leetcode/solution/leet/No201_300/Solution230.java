package com.kingsley.leetcode.solution.leet.No201_300;

import com.kingsley.leetcode.entity.TreeNode;
import com.kingsley.leetcode.type.construct.Tree;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Time 2021/10/17 13:15
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/">230. 二叉搜索树中第K小的元素</a>
 * <div>
 *     <p>  输入：k = 1, root = </p>
 *     <img src="https://assets.leetcode.com/uploads/2021/01/28/kthtree1.jpg"/>
 *     <p>  输出：1</p>
 * </div>
 */
@SolutionInfo(value = "230. 二叉搜索树中第K小的元素", requirements = "进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？")
public class Solution230 extends Solution implements Tree {

    @SolutionEntry(priority = 1)
    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        dfs(root, queue, k);
        return queue.peek();
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> queue, int k) {
        if (queue.size() < k) {
            queue.offer(root.val);
        } else {
            if (!queue.isEmpty() && root.val < queue.peek()) {
                queue.poll();
                queue.offer(root.val);
            }
        }
        if (root.left != null) {
            dfs(root.left, queue, k);
        }
        if (root.right != null) {
            dfs(root.right, queue, k);
        }
    }

    @SolutionEntry
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        mid(root, list, k);
        return list.getLast();
    }

    private void mid(TreeNode root, LinkedList<Integer> list, int k) {
        if (list.size() == k) {
            return;
        }
        if (root.left != null) {
            mid(root.left, list, k);
        }
        if (list.size() == k) {
            return;
        }
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        if (root.right != null) {
            mid(root.right, list, k);
        }
    }

    @Test
    @Override
    public void test() {
        TreeNode root = TreeNode.builder()
                .val(5)
                .right(new TreeNode(6))
                .left(TreeNode.builder()
                        .val(3)
                        .right(new TreeNode(4))
                        .left(TreeNode.builder().val(2).left(new TreeNode(1)).build())
                        .build()
                ).build();
        solute(root, 3);
    }
}
