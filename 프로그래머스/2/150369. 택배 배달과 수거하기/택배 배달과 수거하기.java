import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        
        answer = sol(cap, n, deliveries, pickups, pickups.length);
        
        return answer;
    }
    
    private long sol(int cap, int n, int[] deliveries, int[] pickups, int len){

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<len;i++){
            stack.push(i);
        }
        
        long move = 0;
        
        long[] dm = new long[len];
        long[] pm = new long[len];
        
        while(!stack.isEmpty()){
            int position = stack.pop();
            
            if(deliveries[position]<=0 && pickups[position]<=0){
                //이월이안됨
                if(position > 0){
                    dm[position-1]+=dm[position];
                    pm[position-1]+=pm[position];
                }
                continue;
            }
            
            if(dm[position]==0 && pm[position]==0){
                // System.out.println(position);
                move+=(position+1)*2;
                dm[position]=cap;
                pm[position]=cap;
            }
            
            //   1 0 2 0 0
            //dm 0 0 4 0 0
            
            //   0 3 0 0 0
            //pm 0 0 4 0 0
            
            if(deliveries[position] < dm[position]){
                if(position!=0) dm[position-1] += dm[position] - (long)deliveries[position];
                deliveries[position] = 0;
                dm[position]=0;
            }else{
                deliveries[position] -= (int)dm[position];
                dm[position]=0;
            }
            
            if(pickups[position] < pm[position]){
                if(position!=0) pm[position-1] += pm[position] - (long)pickups[position];
                pickups[position] = 0;
                pm[position]=0;
            }else{
                pickups[position] -= (int)pm[position];
                pm[position]=0;
            }
            
            if(deliveries[position]>0 || pickups[position]>0){
                stack.push(position);
            }
        }
        
        return move;
    }
    
    // private void print(long[] arr){
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }
    //     private void iprint(int[] arr){
    //     for(int i=0;i<arr.length;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }
}