import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        return bfs(n, computers);
    }
    
    int bfs(int n, int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            
            queue.add(i);
            
            while(!queue.isEmpty()){
                int computer = queue.poll();
                visited[computer] = true;
                
                for(int j=0;j<n;j++){
                    if(!visited[j] && j!=computer && computers[computer][j]==1){
                        queue.add(j);
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}