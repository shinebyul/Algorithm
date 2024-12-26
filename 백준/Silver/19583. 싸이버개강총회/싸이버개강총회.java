import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 시간 입력
        String startTime = st.nextToken(); // 개강총회 시작 시간
        String endTime = st.nextToken();   // 개강총회 종료 시간
        String streamEndTime = st.nextToken(); // 스트리밍 종료 시간

        // 입장 및 퇴장 확인을 위한 Set
        Set<String> enteredMembers = new HashSet<>();
        Set<String> confirmedMembers = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] log = input.split(" ");
            String logTime = log[0];
            String nickname = log[1];

            // 입장 확인
            if (logTime.compareTo(startTime) <= 0) {
                enteredMembers.add(nickname);
            }

            // 퇴장 확인
            if (logTime.compareTo(endTime) >= 0 && logTime.compareTo(streamEndTime) <= 0) {
                if (enteredMembers.contains(nickname)) {
                    confirmedMembers.add(nickname);
                }
            }
        }

        // 최종 출력
        System.out.println(confirmedMembers.size());
    }
}