import java.util.*;

public class Solution {
    int maxDivisor(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // 배열의 GCD 계산
    int findGCD(int[] array) {
        int result = array[0];
        for (int num : array) {
            result = maxDivisor(result, num);
            if (result == 1) break;
        }
        return result;
    }

    // 배열 조건 확인
    boolean check(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);

        int resultA = check(gcdA, arrayB) ? gcdA : 0;
        int resultB = check(gcdB, arrayA) ? gcdB : 0;

        return Math.max(resultA, resultB);
    }
}