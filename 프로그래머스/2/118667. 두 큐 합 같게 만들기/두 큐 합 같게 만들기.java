import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 큐의 총 합 계산
        long sum1 = 0;
        long sum2 = 0;
        
        for (int num : queue1){
            sum1 += num;
        }
        for (int num : queue2){
            sum2 += num;
        }

        // 합이 홀수인 경우 -1반환
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        // 목표 숫자
        long target = (sum1 + sum2) / 2;

        // 큐를 배열에 합치기
        // 3,2,7,2,4,6,5,1
        int n = queue1.length;
        int[] combined = new int[n * 2];
        for (int i = 0; i < n; i++) {
            combined[i] = queue1[i];
        }
        for (int i = 0; i < n; i++) {
            combined[n + i] = queue2[i];
        }

        // 3,2,7,2,4,6,5,1
        int left = 0, right = n;
        long sum = sum1;
        int answer = 0;

        while (left < combined.length && right < combined.length) {
            if (sum == target) return answer;
            if (sum < target) {
                sum += combined[right++];
            } else {
                sum -= combined[left++];
            }
            answer++;
        }

        return -1;
    }
}