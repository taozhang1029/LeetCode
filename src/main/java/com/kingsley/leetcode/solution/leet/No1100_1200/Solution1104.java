package com.kingsley.leetcode.solution.leet.No1100_1200;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhangtao552
 * @time: 2021/7/29 9:59
 * @description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/">1104. 二叉树寻路</a>
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * @see <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/06/28/tree.png"></img>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * 1 <= label <= 10^6
 */
@Slf4j
public class Solution1104 extends Solution {

    @SolutionEntry
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new LinkedList<>();
        double tmp = Math.log(label + 1) / Math.log(2);
        int layer = (tmp == (int) tmp) ? (int) tmp : (int) tmp + 1;
        while (layer > 0) {
            result.add(label);
            int preCnt = (int) (Math.pow(2, layer - 1) - 1);
            int idx = label - preCnt;
            int parentIdx = (idx % 2 == 0) ? idx / 2 : idx / 2 + 1;
            parentIdx = (int) (Math.pow(2, layer - 2) - parentIdx + 1);
            int parentLineMax = (int) (Math.pow(2, layer - 1) - 1);
            label = (int) (parentLineMax - (Math.pow(2, layer - 2) - parentIdx));
            layer--;
        }
        Collections.reverse(result);
        return result;
    }

    @Test
    @Override
    public void test() {
        solute(14); // [1,3,4,14]
        solute(16); // [1,3,4,15,16]
    }
}
