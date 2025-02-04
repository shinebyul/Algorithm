
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int rLen = maps.length;
        int cLen = maps[0].length;
        
        
        
        return bfs(maps, rLen, cLen);
    }
    
    int bfs(int[][] maps, int rLen,int cLen){
        Integer min = Integer.MAX_VALUE;
        Queue<Integer[]> queue = new LinkedList<>();
        int[][] visited = new int[rLen][cLen];
        
        int[] dc = {0, 0, -1, 1};
        int[] dr = {-1, 1, 0, 0};
        
        queue.add(new Integer[]{0, 0, 0});
        
        while(!queue.isEmpty()){
            Integer[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            int count = pos[2];
            
            if(visited[r][c]==1) continue;
            
            if(r==rLen-1 && c==cLen-1){
                min = Math.min(count+1, min);
                continue;
            }
            
            visited[r][c] = 1;
            
            for(int i=0;i<4;i++){
                int mr = r+dr[i];
                int mc = c+dc[i];
                
                if(mr<0 || mr>=rLen || mc<0 || mc>=cLen) continue;
                
                if(maps[mr][mc]==1 && visited[mr][mc]==0){
                    queue.add(new Integer[]{mr, mc, count+1});
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}