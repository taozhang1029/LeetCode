package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.api.ListNode;
import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

/**
 * @Time 2021/9/3 16:23
 * @Author Kingsley
 * @Project LeetCode
 * @Description 【2021/9/2 每日一题】
 * @see <a href="https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">剑指 Offer 22. 链表中倒数第k个节点</a>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Solution22 implements Solution {

    @Test
    @Override
    public void test() {
        solute(ListNode.builder()
                .val(1)
                .next(ListNode.builder()
                        .val(2)
                        .next(ListNode.builder()
                                .val(3)
                                .next(ListNode.builder()
                                        .val(4)
                                        .next(ListNode.builder()
                                                .val(5)
                                                .next(ListNode.builder()
                                                        .val(6)
                                                        .build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build(), 3);
    }

    @SolutionEntry
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
