import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 1. 정렬 , stack에 넣기
        Stack<int[]> stack = sort(targets);
        
        // 2. 하나씩 꺼내서 삭제
        answer = yogeuk(stack);
        
        return answer;
    }
    
    private Stack<int[]> sort(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(a -> a[0]));
        
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < targets.length; i++) {
            stack.push(targets[i]);
        }
        
        return stack;
    }
    
    private int yogeuk(Stack<int[]> stack){
        int count = 0;
        
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            count++;
            // System.out.println(top[0]+","+top[1]);
            if(stack.isEmpty()){
                return count;
            }
            int[] peek = stack.peek();
            while(peek[0]<=top[0] && top[0]<peek[1]){
                // System.out.print("peek : ");
                // System.out.println(peek[0]+","+peek[1]);
                stack.pop();
                if(stack.isEmpty()){
                    return count;
                }
                peek = stack.peek();
                // System.out.print("new peek : ");
                // System.out.println(peek[0]+","+peek[1]);
            }
        }
        
        return count;
    }
}