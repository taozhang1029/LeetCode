package com.kingsley.leetcode.solution.leet.No401_500;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.SolutionEntry;
import com.kingsley.leetcode.api.SolutionInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time 2021/9/24 12:42
 * @Author Kingsley
 * @Project LeetCode
 * @Description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/">430. 扁平化多级双向链表</a>
 */
@SolutionInfo(solutionName = "扁平化多级双向链表")
public class Solution403 extends Solution {

    @SolutionEntry
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node next = flatten(head.next);
        Node child = head.child;
        if (child != null) {
            head.child = null;
            Node childFlatten = flatten(child);
            Node tmp = childFlatten;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = next;
            if (next != null) {
                next.prev = tmp;
            }
            head.next = childFlatten;
            childFlatten.prev = head;
        } else {
            head.next = next;
            if (next != null) {
                next.prev = head;
            }
        }
        return head;
    }

    @Test
    @Override
    public void test() {
        Node head = Node.builder().val(1)
                .next(Node.builder().val(2)
                        .next(Node.builder().val(3)
                                .next(Node.builder().val(4)
                                        .next(Node.builder().val(5)
                                                .next(Node.builder().val(6).build()).build()).build())
                                .child(Node.builder().val(7)
                                        .next(Node.builder().val(8)
                                                .next(Node.builder().val(9)
                                                        .next(Node.builder().val(10).build()).build())
                                                .child(Node.builder().val(11)
                                                        .next(Node.builder().val(12).build()).build())
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();
        solute(head);
    }
}

@Builder
class Node {

    public int val;

    public Node prev;

    public Node next;

    public Node child;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<NodeOrder> queue = new LinkedList<>();
        queue.add(new NodeOrder(0, this));
        int cnt;
        boolean renew = false;
        int fillStart = -1;
        while (!queue.isEmpty()) {
            NodeOrder nodeOrder = queue.poll();
            Node node = nodeOrder.getNode();
            int idx = nodeOrder.getIdx();
            cnt = 0;
            fillBlank(fillStart, sb);
            while (node != null) {
                sb.append(node.val);
                if (node.next != null) {
                    sb.append("<-->");
                }
                if (node.child != null) {
                    queue.add(new NodeOrder(cnt + idx, node.child));
                    if (!renew) {
                        fillStart = cnt + idx;
                        renew = true;
                    }
                }
                node = node.next;
                cnt++;
            }
            if (!queue.isEmpty()) {
                sb.append("\n");
                fillBlank(fillStart, sb);
                sb.append("|\n");
            }
            renew = false;
        }
        return sb.toString();
    }

    private void fillBlank(int order, StringBuilder sb) {
        if (order == -1) {
            return;
        }
        for (int i = 1; i <= order; i++) {
            int bits = String.valueOf(i).length();
            for (int j = 0; j < bits + 4; j++) {
                sb.append(" ");
            }
        }
    }
}

@Data
@AllArgsConstructor
class NodeOrder {

    private int idx;

    private Node node;

}
