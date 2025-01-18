import java.util.*;

class Solution {

    public int solution(int n, int k) {
        String kBaseNumber = Integer.toString(n, k);

        String[] candidates = kBaseNumber.split("0");

        int primeCount = 0;
        for (String candidate : candidates) {
            if (!candidate.isEmpty() && isPrime(Long.parseLong(candidate))) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}