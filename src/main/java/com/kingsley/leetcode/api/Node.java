package com.kingsley.leetcode.api;

/**
 * 带随机指针的链表
 * Created by zhangtao552 on 2021/7/22.
 */
public class Node {

    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Node{");
        Node tmp = this;
        while (tmp != null) {
            sb.append("[").append(tmp.val).append(", ").append(tmp.random == null ? "null" : tmp.random.val).append("], ");
            tmp = tmp.next;
        }
        int length = sb.length();
        sb.delete(length - 2, length).append("}");

        return sb.toString();
    }
}
