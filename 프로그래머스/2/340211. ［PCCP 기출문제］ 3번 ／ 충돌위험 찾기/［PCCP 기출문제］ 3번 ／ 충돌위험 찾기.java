import java.util.*;

class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    int max = 0;
    int[][] map = new int[101][101];
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int num_robots = routes.length;
        
        initMap(); // map 초기화
        findPath(points, routes); // 경로 계산
        answer = collaps(num_robots); // 충돌 횟수 계산
        
        return answer;
    }
    
    private void findPath(int[][] points, int[][] routes) {
        for (int[] route : routes) {
            List<Integer> path = new ArrayList<>();
            
            int len = route.length;
            for (int i = 0; i < len - 1; i++) {
                int s = route[i];
                int e = route[i + 1];
                int s_x = points[s - 1][0];
                int s_y = points[s - 1][1];
                int e_x = points[e - 1][0];
                int e_y = points[e - 1][1];
                
                while (s_x != e_x) {
                    path.add(map[s_x][s_y]);
                    if (s_x > e_x) {
                        s_x--;
                    } else {
                        s_x++;
                    }
                }
                
                while (s_y != e_y) {
                    path.add(map[s_x][s_y]);
                    if (s_y > e_y) {
                        s_y--;
                    } else {
                        s_y++;
                    }
                }
            }
            path.add(map[points[route[len - 1] - 1][0]][points[route[len - 1] - 1][1]]); // 마지막 경로 추가
            paths.add(path);
            if (max < path.size()) max = path.size(); // 최장 경로 계산
        }
    }
    
    private int collaps(int num_robots) {
        int ret = 0;
        
        for (int j = 0; j < max; j++) {
            Map<Integer, Integer> coll = new HashMap<>();
            
            for (int i = 0; i < num_robots; i++) {
                if (j < paths.get(i).size()) { 
                    int currentPoint = paths.get(i).get(j);
                    coll.put(currentPoint, coll.getOrDefault(currentPoint, 0) + 1);
                }
            }
            
            // 충돌 카운트 증가 (각 시간별로 정확히 같은 위치에 있는 경우만 확인)
            for (int count : coll.values()) {
                if (count > 1) {
                    ret++;
                }
            }
        }
        
        return ret;
    }
    
    private void initMap(){
        
        int n=0;
        
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                map[i][j] = n++;
            }
        }
    }
}