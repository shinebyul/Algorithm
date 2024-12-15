import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            tasks.add(new Task(d, w));
        }

        // 1. 마감일 기준으로 정렬
        tasks.sort(Comparator.comparingInt(task -> task.deadline));

        // 2. 최소 힙을 사용하여 최대 점수 계산
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Task task : tasks) {
            minHeap.add(task.score); // 힙에 점수를 추가
            // 힙 크기가 마감일을 초과하면, 최소 점수를 제거
            if (minHeap.size() > task.deadline) {
                minHeap.poll();
            }
        }

        // 3. 힙에 남아 있는 점수의 합 계산
        int maxScore = 0;
        while (!minHeap.isEmpty()) {
            maxScore += minHeap.poll();
        }

        // 결과 출력
        System.out.println(maxScore);
    }

    // Task 클래스 정의
    static class Task {
        int deadline, score;

        Task(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }
    }
}