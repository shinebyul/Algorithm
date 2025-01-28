import java.util.*;

class Solution {
    
    public int[][] visited;
    
    public ArrayList<Integer> ans = new ArrayList<>();
    
    public int w,h;
    
    public int[] solution(String[] grid) {
        
        visited = new int[grid.length][grid[0].length()];
        
        // 열 최대 길이
        h = grid.length;
        // 행 최대 길이
        w = grid[0].length();
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                for(int d = 0; d < 4; d++){
                    // 해당 위치에 해당방향에서 온적 있는지 체크
                    if((visited[i][j] & (1<<d)) == 1<<d){
                        continue;
                    }
                    int cnt = bfs(i,j,d,grid);
                    ans.add(cnt);
                }
            }
        }
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int bfs(int x, int y, int d, String[] grid){
        // 오른쪽으로 도는 구조(동,북,서,남)
        int[] dirX = {0,1,0,-1};
        int[] dirY = {1,0,-1,0};
        
        int cnt = 0;
            
        while(true){
            // 왔던 곳에 같은 방향으로 오면 사이클
            if((visited[x][y] & (1<<d)) == 1<<d){
                break;
            }
            //거리 증가 및 방문처리
            cnt++;
            visited[x][y] |= (1<<d);
            
            // 방향 회전
            if(grid[x].charAt(y) == 'L'){
                d = d == 0 ? 3 : d-1;
            }else if(grid[x].charAt(y) == 'R'){
                d = d == 3 ? 0 : d+1;
            }
            
            x = (x + dirX[d] + h) % h;
            y = (y + dirY[d] + w) % w;
        }
        
        return cnt;
    }
}