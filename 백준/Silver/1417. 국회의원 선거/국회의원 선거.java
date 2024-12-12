import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;  
public class Main {  public static void main(String[] args) throws IOException {
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int count = Integer.parseInt(br.readLine());
 int target = 0;
 PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
 for (int i = 0; i < count; i++) {
 if (i == 0) {
 target = Integer.parseInt(br.readLine());
 } else {
 priorityQueue.add(Integer.parseInt(br.readLine()));
 }
 }  int vote = 0;
 while (!priorityQueue.isEmpty()) {
 int val = priorityQueue.poll();
 if (val >= target) {
 priorityQueue.add(val - 1);
 target++;
 vote++;
 } else {
 break;
 }
 }
 System.out.println(vote);
}
 }