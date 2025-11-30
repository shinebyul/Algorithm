import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        for (int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        return answer - 1;
    }
}