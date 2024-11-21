import java.util.*;

class Solution {
    
    static int result = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        dfs(picks, minerals, 0, 0);
        return result;
    }
         
    public static void dfs(int[] picks, String[] minerals, int depth, int stress) {
        if (depth == minerals.length || Arrays.stream(picks).sum() == 0) {
            result = Math.min(result, stress);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                int sum = stress;
                for (int j = depth; j < Math.min(depth + 5, minerals.length); j++) {
                    if (i == 0) {
                        sum += 1;
                    } else if (i == 1) {
                        if (minerals[j].equals("diamond")) {
                            sum += 5;
                        } else {
                            sum += 1;
                        }
                    } else if (i == 2) {
                        if (minerals[j].equals("diamond")) {
                            sum += 25;
                        } else if (minerals[j].equals("iron")) {
                            sum += 5;
                        } else {
                            sum += 1;
                        }
                    }
                }
                dfs(picks, minerals, depth + 5, sum);
                picks[i]++;
            }
        }
    }
}