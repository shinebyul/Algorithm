import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int temp = arr[i], start = 0, end = N-1;

            while (start != end){

                if(start == i) {
                    start++;
                    continue;
                }
                if(end == i) {
                    end--;
                    continue;
                }

                if(arr[start] + arr[end] > temp){
                    end--;
                }else if(arr[start] + arr[end] < temp){
                    start++;
                }else if(arr[start] + arr[end] == temp){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}