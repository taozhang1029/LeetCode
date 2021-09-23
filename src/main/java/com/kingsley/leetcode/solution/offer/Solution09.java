package com.kingsley.leetcode.solution.offer;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * Created by zhangtao552 on 2021/7/21.
 */
@Slf4j
public class Solution09 extends Solution {

    private Stack<Integer> stackIn;

    private Stack<Integer> stackOut;

    public Solution09() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.add(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.add(stackIn.pop());
            }
        }
        if (stackOut.isEmpty()) {
            return -1;
        }
        return stackOut.pop();
    }

    @SolutionEntry
    private void cQueueTest() {
        appendTail(1);
        appendTail(2);
        appendTail(3);

        log.info("存入：{}->{}->{}", 1, 2, 3);

        log.info("弹出：{}->{}", deleteHead(), deleteHead());

        appendTail(4);
        appendTail(5);
        log.info("存入：{}->{}", 4, 5);

        log.info("弹出：{}->{}->{}->{}", deleteHead(), deleteHead(), deleteHead(), deleteHead());
    }

    @Test
    @Override
    public void test() {
        solute();
    }
}
