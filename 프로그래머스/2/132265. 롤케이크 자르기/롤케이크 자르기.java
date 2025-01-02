class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //[1, 2, 1, 3, 1, 4, 1, 2] 
        //[1, 2, 2, 3, 3, 4, 4, 4] left
        //[4 ,4 ,4 ,4 ,3 ,3 ,2 ,1] right
        
        int[] visited_l = new int[10001];
        int[] visited_r = new int[10001];
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        
        left[0]=1;
        visited_l[topping[0]]=1;
        
        for(int i=1;i<topping.length-1;i++){
            if(visited_l[topping[i]]==0){
                left[i] = left[i-1]+1;
                visited_l[topping[i]]=1;
            }else{
                left[i] = left[i-1];
            }
        }
        
        right[topping.length-1]=1;
        visited_r[topping[topping.length-1]]=1;
        
        for(int i=topping.length-2;i>=1;i--){
            if(visited_r[topping[i]]==0){
                right[i] = right[i+1]+1;
                visited_r[topping[i]]=1;
            }else{
                right[i] = right[i+1];
            }
        }
        
        for(int i=0;i<topping.length-1;i++){
            if(left[i]==right[i+1]) answer++;
        }
        
        
        return answer;
    }
}