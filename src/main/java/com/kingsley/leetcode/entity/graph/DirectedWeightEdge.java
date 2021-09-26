package com.kingsley.leetcode.entity.graph;

/**
 * @author: zhangtao552
 * @time: 2021/8/2 17:42
 * @description 有向加权图的边
 */
public class DirectedWeightEdge {

    private int from;

    private int to;

    private int weight;

    public DirectedWeightEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return from + " -> " + to + ", weight: " + weight;
    }
}
