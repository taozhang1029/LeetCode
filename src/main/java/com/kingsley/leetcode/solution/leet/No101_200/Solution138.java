package com.kingsley.leetcode.solution.leet.No101_200;

import com.kingsley.leetcode.api.Node;
import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表 https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 * <p>
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * <p>
 * Created by zhangtao552 on 2021/7/22.每日一题
 */
public class Solution138 implements Solution {

    @Test
    @Override
    public void test() {
        solute(getTestNode());
    }

    @SolutionEntry
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node tmp = head;
        Node last = null;
        while (tmp != null) {
            Node curr = new Node(tmp.val);
            if (last != null) {
                last.next = curr;
            }
            last = curr;
            map.put(tmp, curr);
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            Node random = tmp.random;
            if (random != null) {
                Node newNode = map.get(tmp);
                newNode.random = map.get(random);
            }
            tmp = tmp.next;
        }

        return map.get(head);
    }

    private Node getTestNode() {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node1 = new Node(7);

        Node node2 = new Node(13);
        node2.random = node1;
        node1.next = node2;

        Node node3 = new Node(11);
        node2.next = node3;

        Node node4 = new Node(10);
        node4.random = node3;
        node3.next = node4;

        Node node5 = new Node(1);
        node5.random = node1;
        node4.next = node5;
        node3.random = node5;

        return node1;
    }

}
