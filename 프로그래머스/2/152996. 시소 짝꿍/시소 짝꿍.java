import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        int[] arr = new int[1001];
        
        for(int i=0;i<weights.length;i++){
            if(arr[weights[i]] > 0){
                answer+=(long)arr[weights[i]];
            }
            
            arr[weights[i]]++;
            if(weights[i]*2 <= 1000){
                arr[weights[i]*2]++;
            }
            if(weights[i]*3%2==0 && weights[i]*3/2 <= 1000){
                arr[weights[i]*3/2]++;
            }
            if(weights[i]*4%3==0 && weights[i]*4/3 <= 1000){
                arr[weights[i]*4/3]++;
            }
            
        }
        
        return answer;
    }
}