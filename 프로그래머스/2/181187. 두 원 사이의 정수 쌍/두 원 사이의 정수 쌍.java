class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long count = 0;
        
        for(int i=1;i<r2;i++){
            // System.out.println("i : "+i);
            // int max = (int)Math.sqrt(r2*r2-()i*i);
            int max = (int) Math.sqrt((long) r2 * r2 - (long) i * i);
            int min = 1;
            
            if(i < r1){
                double dou = Math.sqrt((long) r1 * r1 - (long) i * i);
                min = dou == (int)dou ? (int)dou : (int)(dou + 1.0);
            }
            // System.out.println("max : "+max);
            count+=(max-min+1);
        }
        
        answer = count*4 + 4*(r2-r1+1);
        
        return answer;
    }
    
}