package com.kingsley.leetcode.solution.leet.No1_100;

import com.kingsley.leetcode.entity.TreeNode;
import com.kingsley.leetcode.type.construct.Tree;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Time 2021/10/17 13:58
 * @Author Kingsley
 * @Project LeetCode
 * @Description
 */
@SolutionInfo(value = "94. 二叉树的中序遍历", requirements = "进阶: 递归算法很简单，你可以通过迭代算法完成吗？")
public class Solution94 extends Solution implements Tree {

    /**
     * 迭代实现
     */
    @SolutionEntry
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    /**
     * 递归实现
     */
    @SolutionEntry(priority = 1)
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            dfs(result, root);
        }
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            dfs(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            dfs(result, root.right);
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
        solute(root);
    }
}
