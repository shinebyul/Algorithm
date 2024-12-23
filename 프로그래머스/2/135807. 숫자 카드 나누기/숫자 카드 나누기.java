import java.util.*;

public class Solution {
    // 최대 공약수 계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 배열의 GCD 계산
    private static int findGCD(int[] array) {
        int result = array[0];
        for (int num : array) {
            result = gcd(result, num);
            if (result == 1) break; // GCD가 1이면 더 이상 계산할 필요 없음
        }
        return result;
    }

    // 배열 조건 확인 (gcd가 다른 배열의 모든 숫자를 나누지 못하는지)
    private static boolean doesNotDivideAll(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false; // 하나라도 나누어진다면 조건 불만족
            }
        }
        return true;
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        // 1. 각 배열의 GCD 계산
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);

        // 2. 조건에 따라 가장 큰 양의 정수 계산
        int resultA = doesNotDivideAll(gcdA, arrayB) ? gcdA : 0;
        int resultB = doesNotDivideAll(gcdB, arrayA) ? gcdB : 0;

        // 3. 두 결과 중 더 큰 값 반환
        return Math.max(resultA, resultB);
    }
}