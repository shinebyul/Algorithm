class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int[] count = calCount(board);
        int check = checkCount(count);
        
        if(check==-1){
            check = validate(count, board);
        }
        
        answer = check;
        
        return answer;
    }
    
    private int[] calCount(String[] board){
        int[] count = new int[2];
        int o = 0;
        int x = 0;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='O') o++;
                else if(board[i].charAt(j)=='X') x++;
            }
        }
        count[0] = o;
        count[1] = x;
        
        return count;
    }
    
    private int checkCount(int[] count){
        if(count[0] < count[1]) return 0;
        if(count[0]-count[1] >= 2) return 0;
        if(count[0] > 3 && count[0] > count[1]) return -1;
        if(count[0] >= 3 && count[0]==count[1]) return -1;
        return 1;
    }
    
    private int validate(int[] count, String[] board){

        if(count[0] >= 3 && count[0]==count[1]){
            //같은 행인지
            for(int i=0;i<3;i++){
                if(board[i].equals("OOO")){
                    return 0;
                }
            }
            //같은 열인지
            for(int j=0;j<3;j++){
                if(board[0].charAt(j)=='O' &&
                   board[1].charAt(j)=='O' &&
                   board[2].charAt(j)=='O'){
                    return 0;
                }
            }
            //대각선인지
            if(board[0].charAt(0)=='O' && 
               board[1].charAt(1)=='O' && 
               board[2].charAt(2)=='O'){
                return 0;
            }
            if(board[0].charAt(2)=='O' && 
               board[1].charAt(1)=='O' && 
               board[2].charAt(0)=='O'){
                return 0;
            }
            
        }else{
            //같은 행인지
            for(int i=0;i<3;i++){
                if(board[i].equals("XXX")){
                    return 0;
                }
            }
            //같은 열인지
            for(int j=0;j<3;j++){
                if(board[0].charAt(j)=='X' &&
                   board[1].charAt(j)=='X' &&
                   board[2].charAt(j)=='X'){
                    return 0;
                }
            }
            //대각선인지
            if(board[0].charAt(0)=='X' && 
               board[1].charAt(1)=='X' && 
               board[2].charAt(2)=='X'){
                return 0;
            }
            if(board[0].charAt(2)=='X' && 
               board[1].charAt(1)=='X' && 
               board[2].charAt(0)=='X'){
                return 0;
            }
        
        }
        
        return 1;
    }
}