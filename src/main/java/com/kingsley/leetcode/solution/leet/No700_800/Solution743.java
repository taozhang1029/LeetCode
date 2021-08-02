package com.kingsley.leetcode.solution.leet.No700_800;

import com.kingsley.leetcode.api.Solution;
import com.kingsley.leetcode.api.graph.DirectedWeightEdge;
import com.kingsley.leetcode.api.graph.DirectedWeightGraph;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangtao552
 * @time: 2021/8/2 16:22
 * @description 每日一题
 * @see <a href="https://leetcode-cn.com/problems/network-delay-time/">743. 网络延迟时间</a>
 * <img src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png">
 * 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，
 * 其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 */
public class Solution743 implements Solution {

    @Test
    @Override
    public void test() {
        // times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2 --> 2
        // times = [[1,2,1],[2,3,2],[1,3,4]], n = 3, k = 1 --> 3
        int[][] times1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times2 = {{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        solute(times1, 4, 2);
        solute(times2, 3, 1);
    }

    @SolutionEntry
    public int networkDelayTime(int[][] times, int n, int k) {

        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;

    }

    private int error(int[][] times, int n, int k) {
        final int MAX = 6000 * 100;

        if (n == 1) {
            return 0;
        }
        DirectedWeightGraph graph = new DirectedWeightGraph(n);
        for (int[] item : times) {
            graph.addEdge(new DirectedWeightEdge(item[0] - 1, item[1] - 1, item[2]));
        }

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, MAX);
        distance[k - 1] = 0;
        visited[k - 1] = true;

        List<DirectedWeightEdge> edges = graph.getEdges(k - 1);
        for (int i = 1; i < n; i++) {
            // Optional<DirectedWeightEdge> optional = edges.stream().filter(e -> !visited[e.getTo()]).min(Comparator.comparingInt(DirectedWeightEdge::getWeight));
            // if (!optional.isPresent()) {
            //     break;
            // }
            // DirectedWeightEdge edge = optional.get();

            int minDistance = MAX + 1;
            DirectedWeightEdge edge = null;
            for (DirectedWeightEdge e : edges) {
                if (visited[e.getTo()]) {
                    continue;
                }
                if (e.getWeight() <= minDistance) {
                    edge = e;
                    minDistance = e.getWeight();
                }
            }
            if (edge == null) {
                break;
            }
            int to = edge.getTo();
            distance[to] = Math.min(edge.getWeight(), distance[to]);
            visited[to] = true;
            List<DirectedWeightEdge> toEdges = graph.getEdges(to);
            for (DirectedWeightEdge e : toEdges) {
                int t1 = e.getTo();
                distance[t1] = Math.min(distance[t1], distance[to] + e.getWeight());
            }
        }
        int max = Arrays.stream(distance).max().getAsInt();
        return max == MAX ? -1 : max;
    }

}
