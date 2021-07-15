package com.kingsley.leetcode.api;

/**
 * @author kingsley
 * @description 链表节点类
 * @file api.java
 * @time 2021/3/25 下午3:08
 * @project LeetCode
 * @ide Intellij IDEA
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
