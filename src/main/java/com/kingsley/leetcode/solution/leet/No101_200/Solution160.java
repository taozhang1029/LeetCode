package com.kingsley.leetcode.solution.leet.No101_200;

import com.kingsley.leetcode.api.ListNode;
import com.kingsley.leetcode.solution.offer.Solution52;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 同题 {@link Solution52#getIntersectionNode(ListNode, ListNode)}
 * <p>
 * 时间复杂度O(n)，空间复杂度O(1)
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * <p>
 * Created by zhangtao552 on 2021/7/21.
 */
@Component
public class Solution160 implements Solution {

    @Test
    @Override
    public void test() {
        ListNode commonNode = ListNode.builder().val(1).next(
            ListNode.builder().val(8).next(
                ListNode.builder().val(4).next(
                    ListNode.builder().val(5).build()
                ).build()
            ).build()
        ).build();

        ListNode headA = ListNode.builder().val(4).next(
            commonNode
        ).build();

        ListNode headB = ListNode.builder().val(5).next(
            ListNode.builder().val(0).next(
                commonNode
            ).build()
        ).build();

        solute(headA, headB);
    }

    @SolutionEntry
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        boolean headAVisited = false;
        boolean headBVisited = false;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                if (headBVisited) {
                    return null;
                }
                node1 = headB;
                headBVisited = true;
            }
            if (node2 == null) {
                if (headAVisited) {
                    return null;
                }
                node2 = headA;
                headAVisited = true;
            }
        }
        return node1;
    }

}
