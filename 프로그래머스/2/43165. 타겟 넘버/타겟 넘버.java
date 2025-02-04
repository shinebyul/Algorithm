class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    int dfs(int[] numbers, int target, int depth, int n){
        if(depth==numbers.length){
            if(n==target) return 1;
            return 0;
        }
        
        return dfs(numbers, target, depth+1, n+numbers[depth]) + dfs(numbers, target, depth+1, n-numbers[depth]);
    }
}