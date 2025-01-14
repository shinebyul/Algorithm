import java.util.*;

class Solution {
    int[] visited;
    Queue<Integer> queue = new LinkedList<>();
    int max;
    
    public int solution(int[] info, int[][] edges) {
        
        boolean visit[] = new boolean[info.length];
        int sheep = 0;
        int wolf = 0;
        max = 0;
        dfs(visit, 0, info, edges, sheep, wolf);
        
        return max;
    }
    private void dfs(boolean[] visit, int root, int[] info, int[][] edges, int sheep, int wolf){

        visit[root] = true;
        
        if(info[root] == 0){
            sheep++;
            if(sheep > max){
                max = sheep;
            }
        }else{
            wolf++;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            if(visit[x] && !visit[y]) {
                boolean[] next = new boolean[visit.length];
                for (int i = 0; i < visit.length; i++) {
                    next[i] = visit[i];
                }
                dfs(next,y, info, edges, sheep, wolf);
            }
        }
    }
}