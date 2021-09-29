package com.kingsley.leetcode.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * 树节点
 * Created by zhangtao552 on 2021/7/26.
 */
@Builder
@NoArgsConstructor
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TreeNode{");
        TreeNode root = this;
        dfs(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append("->[");
        } else {
            return;
        }
        if (root.left != null) {
            dfs(root.left, sb);
            if (root.right == null) {
                sb.append("]");
                return;
            }
            sb.append(", ");
        }
        dfs(root.right, sb);
        sb.append("]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
