import java.util.*;

public class Main {
    private static HashMap<Long, Long> memo = new HashMap<>();

    private static long calculate(long i, long P, long Q) {
        if (i == 0) return 1; 
        if (memo.containsKey(i)) return memo.get(i); 

        long value = calculate(i / P, P, Q) + calculate(i / Q, P, Q);
        memo.put(i, value); 
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();
        long P = scanner.nextLong();
        long Q = scanner.nextLong();

        System.out.println(calculate(N, P, Q));
    }
}