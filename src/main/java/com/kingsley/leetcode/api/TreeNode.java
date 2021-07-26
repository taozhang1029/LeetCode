package com.kingsley.leetcode.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 树节点
 * Created by zhangtao552 on 2021/7/26.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
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
}
