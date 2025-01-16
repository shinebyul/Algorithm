import java.util.*;

class Solution {
    int max;
    
    public int solution(int[] info, int[][] edges) {
        
        int sheep = 0;
        int wolf = 0;
        max = 0;
        boolean visited[] = new boolean[info.length];
        dfs(info, edges, visited, sheep, wolf, 0);
        
        return max;
    }
    
    private void dfs(int[] info, int[][] edges, boolean[] visited, int sheep, int wolf, int root){

        visited[root] = true;
        
        if(info[root] == 0){ // 양일 경우
            sheep++;
            if(sheep > max){
                max = sheep;
            }
        }else{ //늑대일 경우
            wolf++;
        }
        
        if(sheep <= wolf){
            return;
        }
        
        for(int[] edge: edges){
            int parent = edge[0];
            int child = edge[1];
            if(visited[parent] && !visited[child]) {
                boolean[] newVisited = new boolean[visited.length];
                for (int i = 0; i < visited.length; i++) {
                    newVisited[i] = visited[i];
                }
                dfs(info, edges, newVisited, sheep, wolf, child);
            }
        }
    }
}