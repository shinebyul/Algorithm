
import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        bfs(numbers, target);
        return answer;
    }
    void bfs(int[] numbers, int target){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<Math.pow(2,i);j++){
                int n = queue.poll();
                queue.add(n+numbers[i]);
                queue.add(n-numbers[i]);
            }
        }
        
        while(!queue.isEmpty()){
            if(queue.poll()==target) answer++;
        }
    }
}