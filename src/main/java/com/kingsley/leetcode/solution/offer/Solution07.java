package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.entity.TreeNode;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/">剑指 Offer 07. 重建二叉树</a>
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Created by zhangtao552 on 2021/7/23.
 */
public class Solution07 extends Solution {

    @Test
    @Override
    public void test() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        solute(preorder, inorder);
    }

    @SolutionEntry(countTime = true)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIdxMap.put(inorder[i], i);
        }
        return rebuild(inIdxMap, preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode rebuild(HashMap<Integer, Integer> inIdxMap, int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInIdx = inIdxMap.get(root.val);
        int leftLength = rootInIdx - inStart;
        root.left = rebuild(inIdxMap, preorder, preStart + 1, preStart + leftLength, inStart, rootInIdx - 1);
        root.right = rebuild(inIdxMap, preorder, preStart + leftLength + 1, preEnd, rootInIdx + 1, inEnd);
        return root;
    }
}
