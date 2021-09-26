package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.entity.ListNode;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">剑指 Offer 06.从尾到头打印链表</a>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * Created by zhangtao552 on 2021/7/23.
 */
public class Solution06 extends Solution {

    @Test
    @Override
    public void test() {
        solute(ListNode.builder().val(1).next(
            ListNode.builder().val(2).next(
                ListNode.builder().val(3).build()
            ).build()
        ).build());
    }

    @SolutionEntry(countTime = true)
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // StringBuilder sb = new StringBuilder();
        // sb.append(head.val);
        // head = head.next;
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            // sb.append(",").append(head.val);
            head = head.next;
        }

        // return Arrays.stream(sb.reverse().toString().split(",")).mapToInt(Integer::parseInt).toArray();
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
