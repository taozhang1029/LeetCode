package com.kingsley.leetcode.api;

import lombok.Builder;

/**
 * @author kingsley
 * @description 链表节点类
 * @file api.java
 * @time 2021/3/25 下午3:08
 * @project LeetCode
 * @ide Intellij IDEA
 */
@Builder
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListNode{").append(val);
        ListNode tmp = next;
        while (tmp != null) {
            sb.append("->").append(tmp.val);
            tmp = tmp.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
