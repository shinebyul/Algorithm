class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1,-1};
        int l = 0;
        int r = -1;
        int sum=0;
        int len = sequence.length;
        int minLength = Integer.MAX_VALUE;
        
        while(r<len && l<len){
            if(sum < k) {
                if(r+1 >= len) break;
                sum+=sequence[++r];
            }else if(sum > k) {
                sum-=sequence[l++];
            }else{
                if(minLength > r-l){
                    answer[0]=l;
                    answer[1]=r;
                    minLength = r-l;
                }
                sum-=sequence[l++];
            }
        }
        return answer;
    }
}