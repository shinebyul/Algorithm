import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=i*columns+j+1;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            int tmp = arr[x1][y1];
            
            int min = Integer.MAX_VALUE;
            
            //위로 올리기
            for(int j=x1;j<x2;j++){
                arr[j][y1]=arr[j+1][y1];
                min = Math.min(min,arr[j][y1]);
            }
            //왼쪽으로 보내기
            for(int j=y1;j<y2;j++){
                arr[x2][j]=arr[x2][j+1];
                min = Math.min(min,arr[x2][j]);
            }
            //아래로 내리기
            for(int j=x2;j>x1;j--){
                arr[j][y2]=arr[j-1][y2];
                min = Math.min(min,arr[j][y2]);
            }
            //오른쪽으로 보내기
            for(int j=y2;j>y1+1;j--){
                arr[x1][j]=arr[x1][j-1];
                min = Math.min(min,arr[x1][j]);
            }
            arr[x1][y1+1]=tmp;
            min = Math.min(min,tmp);
            
            answer[i]=min;
            // print(arr, rows, columns);
        }
        
        return answer;
    }
    
    void print(int[][] arr, int r, int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}