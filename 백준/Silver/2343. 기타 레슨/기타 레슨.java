import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] lectures = new int[N];
        int maxLen = 0;
        int totalLen = 0; 

        // 강의 총 길이, 강의중 최대 길이 구하기
        for (int i = 0; i < N; i++) {
            lectures[i] = sc.nextInt();
            maxLen = Math.max(maxLen, lectures[i]);
            totalLen += lectures[i];
        }

        int left = maxLen; // 최소 블루레이 크기 >= 장 긴 강의의 길이
        int right = totalLen; // 최대 크기

        while (left < right) {
            int mid = (left + right) / 2;

            if (divide(lectures, M, mid)) {
                right = mid; // mid 크기로 가능하다면 크기를 줄여본다
            } else {
                left = mid + 1; // mid 크기로는 불가능하니 크기를 늘린다
            }
        }

        System.out.println(left); // 최소 블루레이 크기 출력
    }

    private static boolean divide(int[] lectures, int M, int mid) {
        int count = 1;
        int sum = 0; 

        for (int lecture : lectures) {
            if (sum + lecture > mid) {
                count++;
                sum = lecture;
                if (count > M){
                    return false;
                }
            } else {
                sum += lecture;
            }
        }

        return true; // M개의 블루레이로 가능한 경우
    }
}