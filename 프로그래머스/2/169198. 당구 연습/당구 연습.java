class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = { };
        
        int[] ret = new int[balls.length];

		for (int i = 0; i < balls.length; i++) {
			int x = balls[i][0];
			int y = balls[i][1];

            int min = 1000001;
            
			if (!(startX<=x && startY==y )) {
				int len = calLength(startX,2*m-x,  startY, y);
				if(min > len){
                    min = len;
                }
			}

			if (!(startX>=x && startY==y)) {
				int len = calLength(startX, (-1)*x,startY,  y);
                if(min > len){
                    min = len;
                }
			}

			if (!(startX==x && startY >=y)) {
				int len = calLength(startX,x, startY,(-1)*y);
				if(min > len){
                    min = len;
                }
			}

			if (!(startX==x && startY <=y)) {
				int len = calLength(startX, x, startY,2*n - y);
				if(min > len){
                    min = len;
                }
			}

			
			
			ret[i] = min;
		}
        answer = ret;

		return answer;
    }
    
    private int calLength(int s_x, int x, int s_y, int y) {
		int d = (int)(Math.pow(s_x - x, 2) + Math.pow(s_y - y, 2));
        return d;
	}
}