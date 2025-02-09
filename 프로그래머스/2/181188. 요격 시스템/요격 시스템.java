import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 1. 오름차순
        // Arrays.sort(targets, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
        
        // 2. 하나씩 꺼내서 삭제
        answer = yogeuk(targets);
        
        return answer;
    }
    
    private int yogeuk(int[][] targets){
        int count = 0;
        
        int[] f = targets[0];
        count++;
        
        for(int i=1;i<targets.length;i++){
            int[] s = targets[i];
            
            if(s[0]>=f[1]){
                f=targets[i];
                count++;
            }
        }
        
        return count;
    }
}
