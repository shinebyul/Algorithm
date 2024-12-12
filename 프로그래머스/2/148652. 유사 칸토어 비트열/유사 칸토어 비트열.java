class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l - 1; i < r; i++) {
            answer += sol(n, i);
        }

        return answer;
    }
    
    private int sol(int n, long x) {
        if (n == 1 || sol(n - 1, x / 5) != 0) {
            return (x % 5) != 2 ? 1 : 0;
        } else {
            return 0;
        }
    }
}