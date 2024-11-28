import java.util.*;

class Solution {
    class Land {
        int row, col;

        Land(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        int[][] arr = toArray(maps);
        
        List<Land> land = findLand(arr);
        
        answer = mooindou(arr, land);
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int[] mooindou(int[][] maps, List<Land> lands){
        Queue<Land> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[][] visited = new int[maps.length][maps[0].length];
        
        for(int i=0;i<lands.size();i++){
            int r = lands.get(i).row;
            int c = lands.get(i).col;
            if(visited[r][c]==1) continue;
                
            int sum = 0;
            queue.add(new Land(r,c));
            while(!queue.isEmpty()){
                Land land = queue.poll();
                r = land.row;
                c = land.col;
                
                if(visited[r][c]==1) continue;
                
                visited[r][c]=1;
                
                sum+=maps[r][c];
                // System.out.println(r+", "+c+", "+sum);

                //상
                if(r>0 && visited[r-1][c]==0 && maps[r-1][c]!=0){
                    queue.add(new Land(r-1,c));
                }
                //하
                if(r<maps.length-1 && visited[r+1][c]==0 && maps[r+1][c]!=0){
                    queue.add(new Land(r+1,c));
                }
                //좌
                if(c>0 && visited[r][c-1]==0 && maps[r][c-1]!=0){
                    queue.add(new Land(r,c-1));
                }
                //우
                if(c<maps[0].length-1 && visited[r][c+1]==0 && maps[r][c+1]!=0){
                    queue.add(new Land(r,c+1));
                }
            }
            
            list.add(sum);
        }
        
        if(list.size()==0){
            int[] ret = {-1};
            return ret;
        }
        
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }
    
    public List<Land> findLand(int[][] maps){
        List<Land> land = new ArrayList<>();
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length;j++){
                if(maps[i][j]!=0){
                    if(j>0 && maps[i][j-1]!=0) continue;
                    if(i>0 && maps[i-1][j]!=0) continue;
                    land.add(new Land(i,j));
                }
            }
        }
        
        return land;
    }
    
    
    public int[][] toArray(String[] maps){
        int[][] arr = new int[maps.length][maps[0].length()];
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                arr[i][j] = maps[i].charAt(j)=='X' ? 0 : Integer.parseInt(String.valueOf(maps[i].charAt(j)));
            }
        }
        
        return arr;
    }
}