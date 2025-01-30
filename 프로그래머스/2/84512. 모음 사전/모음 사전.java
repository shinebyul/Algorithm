class Solution {
    public String[] dict;
    public int cnt = 0, answer = 0;
    public int solution(String word) {
        dict = "AEIOU".split("");
        dfs("", word);
        
        return answer;
    }
    
    public void dfs(String cur, String word){
        if(cur.length() == 5 || cur.equals(word)){
            if(cur.equals(word)){
                answer = cnt;
            }
            return;
        }
        
        for(int i = 0; i < 5; i++){
            cnt++;
            dfs(cur+dict[i],word);
        }
    }
}