class Solution {
    String[] dict = {"A","E","I","O","U"};
    int answer = 0;
    int cnt = 0;
    
    public int solution(String word) {
        
        dfs("", word);
        
        return answer;
    }
    
    private void dfs(String current, String word){
        if(current.equals(word)){
            answer = cnt;
            return;
        }
        if(current.length() >= 5){
            return;
        }
        for(int i=0;i<5;i++){
            cnt++;
            dfs(current+dict[i], word);
        }
    }
}