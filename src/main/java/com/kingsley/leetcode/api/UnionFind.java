package com.kingsley.leetcode.api;

/**
 * @author kingsley
 * @description 并查集api
 * @file UnionFind.java
 * @time 2021/3/25 下午11:00
 * @project LeetCode
 * @ide Intellij IDEA
 */
public class UnionFind {

    private int count;
    private final int[] sons;
    private final int[] parent;

    public UnionFind(int n) {
        count = n;
        sons = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            sons[i] = 1;
            parent[i] = i;
        }
    }

    public void union(int p, int q) {

        int p0 = find(p);
        int q0 = find(q);

        if (p0 == q0) {
            return;
        }

        if (sons[p0] < sons[q0]) {
            parent[p0] = q0;
            sons[q0] += sons[p0];
        } else {
            parent[q0] = p0;
            sons[p0] += parent[q0];
        }
        count--;

    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(x);
        }
        return parent[x];
    }

    public int getCount() {
        return count;
    }
}
