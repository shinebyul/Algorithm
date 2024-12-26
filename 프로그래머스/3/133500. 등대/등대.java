import java.util.*;

public class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : lighthouse) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        // 루트가 켜졌을 때와 꺼졌을 때 중 최소값
        return Math.min(dp[1][0], dp[1][1]);
    }

    private static void dfs(int node) {
        visited[node] = true;

        // 초기값 설정
        dp[node][0] = 0; // 등대 안킴
        dp[node][1] = 1; // 등대 킴

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);

                // 현재 노드를 켜지 않을 경우 자식 노드 키기
                dp[node][0] += dp[neighbor][1];

                // 현재 노드를 키는 경우 자식 노드 무관
                dp[node][1] += Math.min(dp[neighbor][0], dp[neighbor][1]);
            }
        }
    }
}