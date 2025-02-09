import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, Comparator.comparingInt(a->a[1]));
        
        int range = targets[0][1];
        int count=1;
        
        for(int i=1;i<targets.length;i++){
            if(targets[i][0]>=range){
                count++;
                range = targets[i][1];
            }
        }
        
        return count;
    }
}