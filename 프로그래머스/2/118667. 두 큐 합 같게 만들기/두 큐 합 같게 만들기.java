import java.util.*;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0, totalSum = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;
        totalSum = sum1 + sum2;

        if (totalSum % 2 != 0) return -1;
        long target = totalSum / 2;

        int n = queue1.length;
        int[] combined = new int[n * 2];
        for (int i = 0; i < n; i++) {
            combined[i] = queue1[i];
        }
        for (int i = 0; i < n; i++) {
            combined[n + i] = queue2[i];
        }

        int left = 0, right = n;
        long currentSum = sum1;
        int moves = 0;

        while (left < combined.length && right < combined.length) {
            if (currentSum == target) return moves;
            if (currentSum < target) {
                currentSum += combined[right++];
            } else {
                currentSum -= combined[left++];
            }
            moves++;
        }

        return -1;
    }
}