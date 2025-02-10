import java.util.Arrays;
 
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new long[]{2, 7})));
    }
 
    public static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++; // x보다 큰수로 만든다.
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}