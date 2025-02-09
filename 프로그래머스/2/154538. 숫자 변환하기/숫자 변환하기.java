import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        queue.add(new int[] {x,0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]] = true;
            if(cur[0] == y) {
                answer = cur[1];
                break;
            }
            if(cur[0]*2 <= y && !visited[cur[0]*2]) {
                queue.add(new int[] {cur[0]*2, cur[1]+1});
            }
            if(cur[0]*3 <= y && !visited[cur[0]*3]) {
                queue.add(new int[] {cur[0]*3, cur[1]+1});
            }
            if(cur[0]+n <= y && !visited[cur[0]+n]) {
                queue.add(new int[] {cur[0]+n, cur[1]+1});
            }
        }
        return answer;
    }
}