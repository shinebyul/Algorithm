import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        boolean[] visited = new boolean[N+1];
        int[] costs = new int[N+1]; // 0 1 2 3 4 ... N-1
        //int[] path = new int[N];

        Arrays.fill(costs, Integer.MAX_VALUE);
        //Arrays.fill(path, -1);

        int startNode = 1;
        costs[startNode] = 0;

        for (int i = 0; i < N-1; i++) {
            int minNode = findMinNode(costs, visited);
            visited[minNode] = true;

            for (int[] edge : road) {
                int from;
                int to;
                int cost;
                from = 0;
                to = 0;
                cost = 0;

                // 양방향이라서 이런가
                // 처음 시작 노드를 0을 줬는디 표에는 1로 찾는다
                if (minNode == edge[0]) {
                    from = edge[0];
                    to = edge[1];
                    cost = edge[2];
                } else if (minNode == edge[1]) {
                    from = edge[1];
                    to = edge[0];
                    cost = edge[2];
                }

                if (!visited[to] && from == minNode && costs[from] + cost < costs[to]) {
                    costs[to] = costs[from] + cost;
                    //path[to] = from;
                }
            }
        }
        
        // 최단거리가 k보다 작은 경우 구하기
        int answer = 0;
        for(int i=1; i<costs.length; i++) {
            if(costs[i] <= K) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    // 갈수있는 노드 중에서 제일작은 노드 찾기
    private int findMinNode(int[] costs, boolean[] visited) {
        int minCost = Integer.MAX_VALUE;
        int minNode = 0; // 

        // 한번도 들어가지 않았다?
        for (int i = 1; i < costs.length; i++) {
            if (!visited[i] && costs[i] < minCost) { // 방문하지 않았고 값이 무한보다 작은경우
                minCost = costs[i];
                minNode = i;
            }
        }

        return minNode; // 거리값이 제일 작은 노드 인덱스 반환
    }
}