//수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

//예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
//가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 배열을 유지하기 위한 리스트
        ArrayList<Integer> lis = new ArrayList<>();
        
        for (int num : arr) {
            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                // 현재 숫자가 LIS의 마지막 값보다 크면 추가
                lis.add(num);
            } else {
                // 그렇지 않으면 적절한 위치를 찾아 값 교체
                int pos = binarySearch(lis, num);
                lis.set(pos, num);
            }
        }
        
        // 가장 긴 증가하는 부분 수열의 길이 출력
        System.out.println(lis.size());
    }

    // 이분 탐색으로 적절한 위치를 찾는 함수
    private static int binarySearch(ArrayList<Integer> list, int key) {
        int low = 0, high = list.size() - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}