import java.util.*;

class Solution {

    public int solution(int[][] targets) {
        // 1. 종료 지점을 기준으로 오름차순 정렬
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        double lastIntercept = -1;  // 마지막 요격 미사일의 x 좌표 (최초에는 아무것도 요격하지 않은 상태)

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // 현재 요격 미사일의 위치가 현재 미사일의 범위를 커버하지 못하면 새로운 요격 미사일 필요
            if (lastIntercept < start) {
                answer++;  // 요격 미사일 하나 추가
                lastIntercept = end - 0.5;  // 요격 지점을 end - 0.5로 설정하여 개구간 요건 충족
            }
        }

        return answer;
    }
}