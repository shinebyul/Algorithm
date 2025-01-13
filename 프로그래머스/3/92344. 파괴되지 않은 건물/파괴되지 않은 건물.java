class Solution {
	
    public int solution(int[][] board, int[][] skill) {
        
        int h=board.length;
        int w=board[0].length;
        int[][] map=new int[h+1][w+1];
        
        int answer = 0;
        for(int i=0;i<skill.length;i++){
            
            int type=skill[i][0];
            int r1=skill[i][1];
            int c1=skill[i][2];
            int r2=skill[i][3];
            int c2=skill[i][4];
            int power=skill[i][5];
             
          if(type==1) power*=-1;
          map[r1][c1]+=power;
          map[r1][c2+1]-=power;
          map[r2+1][c1]-=power;
          map[r2+1][c2+1]+=power;
         
          
        }
        
        //가로 누적합 
        for(int i=0;i<h;i++) {
            int sum=0;
        	for(int j=0;j<w;j++) {
        		sum+=map[i][j];
                map[i][j]=sum;
        	}
        }
        
        for(int i=0;i<=w;i++){
            int sum2=0;
        	for(int j=0;j<=h;j++) {
                sum2+=map[j][i];
        		map[j][i]=sum2;
        	}
        }
        
        for(int i=0;i<h;i++) {
        	for(int j=0;j<w;j++) {
        		board[i][j]+=map[i][j];
        		if(board[i][j]>0) answer++;
        	}
        }
    				
        return answer;
    }
}