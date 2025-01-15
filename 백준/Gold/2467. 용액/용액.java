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
        
        int left = 0;
        int right = N - 1;
        int targetLeft = 0;
        int targetRight = N - 1;
        long target = Long.MAX_VALUE; // 최대값으로 초기화
        
        while (left < right) {
            long sum = ph[left] + ph[right];

            // 기존 target과 비교하여 더 나은 결과를 업데이트
            if (Math.abs(sum) < Math.abs(target)) {
                target = sum;
                targetLeft = left;
                targetRight = right;
            }

            // 0에 가까운 값을 찾았으면 종료
            if (sum == 0) break;

            // 투 포인터 이동 로직
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        System.out.println(ph[targetLeft] + " " + ph[targetRight]);
    }
}