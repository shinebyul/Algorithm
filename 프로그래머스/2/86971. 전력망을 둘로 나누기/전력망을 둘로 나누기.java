import java.util.*;

class Solution {
    
    private static boolean[] visit;
    private static List<Integer>[] adj;
    private static int min;
    
    public int solution(int n, int[][] wires) {

		visit = new boolean[n + 1];
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			adj[wires[i][0]].add(wires[i][1]);
			adj[wires[i][1]].add(wires[i][0]);
		}

		min = n;
		dfs(1, n);
		return min;
	}

	private static int dfs(int node, int n) {
		visit[node] = true;
		int size = 1;
		for (int next : adj[node]) {
			if (visit[next])
				continue;

			size += dfs(next, n);
		}

		min = Math.min(min, Math.abs(n - 2 * size));
		return size;
	}
}