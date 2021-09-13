package com.kingsley.leetcode.solution.leet.No700_800;

import com.kingsley.leetcode.util.Solution;
import com.kingsley.leetcode.util.SolutionEntry;
import org.junit.Test;

import java.util.Arrays;

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
        int[][] times3 = {
            {15, 8, 1}, {7, 10, 41}, {7, 9, 34}, {9, 4, 31}, {12, 13, 50}, {14, 3, 52}, {4, 11, 99}, {4, 7, 86}, {10, 13, 57}, {9, 6, 10}, {1, 7, 51},
            {7, 15, 38}, {1, 9, 11}, {12, 7, 94}, {9, 13, 34}, {11, 7, 79}, {7, 6, 28}, {5, 3, 34}, {2, 6, 97}, {14, 1, 97}, {6, 10, 90}, {12, 10, 37},
            {13, 3, 73}, {11, 14, 7}, {15, 1, 39}, {6, 5, 90}, {13, 6, 43}, {6, 9, 32}, {4, 6, 45}, {11, 10, 2}, {2, 13, 4}, {14, 15, 29}, {1, 14, 88},
            {14, 6, 19}, {6, 2, 29}, {3, 14, 72}, {1, 15, 4}, {11, 5, 2}, {6, 7, 56}, {8, 7, 88}, {13, 14, 70}, {14, 12, 58}, {14, 2, 86}, {11, 3, 57},
            {5, 2, 56}, {3, 10, 26}, {2, 11, 21}, {14, 5, 54}, {5, 12, 40}, {14, 4, 81}, {15, 2, 99}, {5, 7, 57}, {13, 12, 5}, {4, 9, 60}, {12, 15, 48},
            {6, 14, 1}, {9, 7, 44}, {13, 7, 69}, {5, 13, 42}, {4, 1, 7}, {11, 9, 76}, {8, 1, 76}, {5, 14, 29}, {2, 3, 69}, {7, 3, 23}, {12, 14, 28},
            {11, 4, 85}, {10, 1, 10}, {15, 12, 36}, {1, 11, 69}, {15, 10, 96}, {11, 13, 69}, {7, 12, 49}, {1, 2, 95}, {6, 4, 46}, {8, 12, 94}, {12, 4, 93},
            {13, 5, 31}, {12, 2, 60}, {6, 1, 87}, {4, 14, 20}, {5, 11, 89}, {4, 15, 88}, {4, 10, 21}, {1, 6, 5}, {10, 8, 26}, {8, 2, 51}, {3, 15, 23},
            {7, 2, 12}, {11, 1, 47}, {2, 1, 75}, {3, 8, 63}, {8, 10, 19}, {6, 8, 18}, {4, 2, 55}, {14, 11, 80}, {10, 3, 73}, {3, 5, 22}, {12, 3, 61},
            {1, 13, 33}, {9, 3, 98}, {9, 12, 69}, {15, 9, 6}, {7, 13, 76}, {11, 12, 22}, {11, 15, 51}, {13, 15, 46}, {5, 10, 58}, {1, 10, 26}, {13, 4, 85},
            {7, 14, 58}, {5, 8, 46}, {11, 6, 32}, {10, 9, 41}, {9, 14, 35}, {14, 13, 60}, {3, 9, 97}, {2, 5, 39}, {7, 11, 19}, {1, 12, 27}, {7, 5, 13},
            {8, 4, 34}, {9, 15, 25}, {5, 1, 93}, {15, 13, 97}, {14, 9, 35}, {8, 6, 67}, {9, 5, 39}, {13, 11, 35}, {7, 4, 21}, {12, 9, 64}, {14, 8, 8},
            {10, 12, 94}, {8, 9, 76}, {8, 5, 71}, {2, 9, 64}, {10, 14, 59}, {1, 4, 74}, {7, 1, 69}, {15, 5, 55}, {6, 15, 80}, {13, 8, 84}, {8, 13, 63},
            {8, 3, 91}, {10, 4, 87}, {1, 5, 39}, {8, 11, 0}, {1, 3, 79}, {4, 5, 82}, {4, 12, 87}, {3, 11, 29}, {7, 8, 92}, {10, 7, 77}, {6, 12, 42},
            {13, 2, 40}, {9, 10, 13}, {4, 13, 65}, {2, 4, 34}, {3, 13, 44}, {2, 14, 69}, {3, 4, 42}, {5, 15, 98}, {14, 7, 6}, {15, 3, 94}, {10, 2, 37},
            {15, 11, 7}, {9, 2, 15}, {13, 9, 66}, {4, 8, 83}, {8, 15, 23}, {13, 1, 50}, {6, 13, 57}, {2, 10, 37}, {10, 6, 38}, {2, 7, 45}, {9, 8, 8},
            {3, 12, 28}, {3, 2, 83}, {2, 12, 75}, {1, 8, 91}, {4, 3, 70}, {12, 6, 48}, {3, 1, 13}, {5, 6, 42}, {6, 11, 96}, {3, 6, 22}, {15, 6, 34}, {11, 8, 43},
            {15, 7, 40}, {9, 11, 57}, {11, 2, 11}, {2, 8, 22}, {9, 1, 73}, {2, 15, 40}, {12, 11, 10}, {15, 4, 78}, {12, 8, 75}, {10, 15, 37}, {13, 10, 44},
            {8, 14, 33}, {3, 7, 82}, {5, 4, 46}, {12, 5, 79}, {15, 14, 43}, {10, 5, 65}, {5, 9, 34}, {12, 1, 54}, {6, 3, 16}, {14, 10, 83}, {10, 11, 67}};

        solute(times1, 4, 2);// 2
        solute(times2, 3, 1);// 3
        solute(times3, 15, 8);// 34
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

}
