import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] requests = new int[n];
        for (int i = 0; i < n; i++) {
            requests[i] = scanner.nextInt();
        }
        int total = scanner.nextInt();

        Arrays.sort(requests);

        int low = 0;
        int high = requests[n - 1];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocate(requests, mid, total)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
        scanner.close();
    }
    
    private static boolean canAllocate(int[] requests, int cap, int total) {
        long allocated = 0;
        for (int req : requests) {
            allocated += Math.min(req, cap);
        }
        return allocated <= total;
    }
}