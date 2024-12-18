import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }else{
                map.put(tangerine[i], 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer key : map.keySet()) {
            pq.add(map.get(key));
        }
        // printmap(map);
        // printpq(pq);
        
        while(!pq.isEmpty()){
            int p = pq.poll();
            if(k <= p){
                answer++;
                break;
            }
            k-=p;
            answer++;
        }
        
        return answer;
    }
    private void printpq(PriorityQueue<Integer> pq){
        while(!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
        System.out.println();
    }
    private void printmap(HashMap<Integer, Integer> map){
        for (Integer key : map.keySet()) {
            System.out.println(key+" : "+map.get(key));
        }
    }
}