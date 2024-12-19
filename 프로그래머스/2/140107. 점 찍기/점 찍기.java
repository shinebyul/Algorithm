import java.util.*;

class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        //1 2 3 4
        //3 6 9 12
        
        answer += d/k + 1;
        
        for(long x = 1*k; x <= d; x += k){
            long maxHeight = (long) Math.sqrt(d*d - x*x);
            answer += maxHeight/k + 1;
        }
        
        
        return answer;
    }
}