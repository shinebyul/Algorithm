import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] ph = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ph[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(ph);

        int left = 0;
        int right = N - 1;
        int targetLeft = 0;
        int targetRight = N - 1;
        long target = Long.MAX_VALUE;

        while (left < right) {
            long sum = ph[left] + ph[right];

            if (Math.abs(sum) < Math.abs(target)) {
                target = sum;
                targetLeft = left;
                targetRight = right;
            }

            if (sum == 0) break;

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ph[targetLeft] + " " + ph[targetRight]);
    }
}