import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size= (int) (right-left+1);
        int[] arr=new int[size];

        for(int i = 0; i < arr.length; i++){
            int row = (int)((i + left) / n) + 1; // row
            int col = (int)((i + left) % n) + 1; // column
            arr[i] = Math.max(row, col);
        }
        return arr;
    }
}