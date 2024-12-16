import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //pq에 들어갈 숫자는 n으로 처리할 적군들
        
        
        for(int i=0;i<enemy.length;i++){
            
            if(n < enemy[i] && k == 0){ // 아군도 부족하고 무적권도 없는 경우 게임 종료
                break;
            }
            
            pq.add(enemy[i]);
            n -= enemy[i];
            
            if(n < 0 && k > 0){ // 아군이 부족한데 무적권이 남아있는 경우
                int p = pq.poll(); // 가장 큰 수를 pq에서 빼고 k(무적권)로 처리
                n+=p;
                k--;
            }
            
            answer++;
        }
        
        return answer;
    }
}