package com.kingsley.leetcode.api.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangtao552
 * @time: 2021/8/2 17:45
 * @description 有向加权图
 */
public class DirectedWeightGraph {

    private int pointNum; // 点的数量

    private int edgeNum; // 边的数量

    private List<DirectedWeightEdge>[] adj; // 邻接表矩阵

    public DirectedWeightGraph(int pointNum) {
        this.pointNum = pointNum;
        this.edgeNum = 0;
        this.adj = new ArrayList[pointNum];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedWeightEdge edge) {
        adj[edge.getFrom()].add(edge);
        edgeNum++;
    }

    public int getPointNum() {
        return pointNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public List<DirectedWeightEdge> getEdges(int point) {
        return adj[point];
    }

    public int getWeight(int from, int to) {
        for (DirectedWeightEdge edge : adj[from]) {
            if (edge.getTo() == to) {
                return edge.getWeight();
            }
        }
        return Integer.MAX_VALUE / 2;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(pointNum + " 个顶点, " + edgeNum + " 条边\n");
        for (int i = 0; i < pointNum; i++) {
            s.append(i).append(": ");
            for (DirectedWeightEdge e : adj[i]) {
                s.append(e.getTo()).append(" [").append(e.getWeight()).append("], ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
