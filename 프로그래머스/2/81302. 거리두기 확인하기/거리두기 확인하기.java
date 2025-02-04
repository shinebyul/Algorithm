class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        char[][][] arr = new char[5][5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    arr[i][j][k] = places[i][j].charAt(k);
                }
            }
        }
        
        for(int i=0;i<places.length;i++){
            answer[i] = fun(arr[i]);
        }
        
        
        return answer;
    }
    
    int fun(char[][] place){
        for(int j=0;j<5;j++){
            for(int k=0;k<5;k++){
                if(place[j][k]=='P'){
                    //대각선 위
                    if(k+1<5 && j-1>=0){
                        if(place[j-1][k+1]=='P' && 
                            !(place[j-1][k]=='X' && 
                           place[j][k+1]=='X')){
                            return 0;
                        }
                    }
                    //대각선 아래
                    if(k+1<5 && j+1<5){
                        if(place[j+1][k+1]=='P' && 
                           !(place[j+1][k]=='X' && 
                           place[j][k+1]=='X')){
                            return 0;
                        }
                    }
                    //오른쪽
                    if(k+1<5 && place[j][k+1]=='P'){
                        return 0;
                    }
                    if(k+2<5 && 
                       place[j][k+2]=='P' && 
                       place[j][k+1]!='X'){
                        return 0;
                    }
                    //아래쪽
                    if(j+1<5 && place[j+1][k]=='P'){
                        return 0;
                    }
                    if(j+2<5 && 
                       place[j+2][k]=='P' && 
                       place[j+1][k]!='X'){
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}