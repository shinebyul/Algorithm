import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        answer = sol(storey);
        
        return answer;
    }
    
    // -1 1 -10 10 -100 100 -1000 1000 -10000 10000
    
    private int sol(int storey){
        int count=0;
        
        while(storey > 0){
            int remain = storey%10;
            storey/=10;
            
            if(remain < 5 || (remain == 5 && storey%10 < 5)){ // 94, 45
                count+=remain;
            }else if(remain > 5 || (remain == 5 && storey%10 >= 5)){ // 99, 95
                count += 10-remain;
                storey++;
            }
            
            
            
        }
        
        return count;
    }
}