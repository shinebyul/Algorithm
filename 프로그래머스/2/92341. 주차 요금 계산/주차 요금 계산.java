import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(int[] fees, String[] records) throws Exception{
        int[] answer = {};
        
        int[] parkingTime = new int[10000];
        int count = 0;
        
        for(String record : records){ //"05:34 5961 IN"
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            Integer carNumber = Integer.parseInt(st.nextToken());
            String history = st.nextToken();
            
            if(parkingTime[carNumber] == 0) count++;
            
            if(history.equals("OUT")){
                parkingTime[carNumber] -= timeCalculator(time);
            }else{
                parkingTime[carNumber] += timeCalculator(time);
            }
        }
        
        answer = feeCalculator(parkingTime, fees, count);
        
        return answer;
    }
    
    private int[] feeCalculator(int[] parkingTime, int[] fees, int count){
        int[] times = new int[count];
        int i=0;
        
        for(int time : parkingTime){
            if(time==0) continue;
            if(fees[0] >= time){
                times[i++]=fees[1];
                continue;
            }
            time-=fees[0];
            int remain = time%fees[2];
            time/=fees[2];
            if(remain>0) time+=1;
            times[i++]=fees[1]+time*fees[3];
        }
        
        return times;
    }
    
    private int timeCalculator(String time) throws Exception{
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        String lastTime = "23:59";

        Date date1 = format.parse(time);
        Date date2 = format.parse(lastTime);

        long diff = date2.getTime() - date1.getTime();
        
        return (int)(diff / (1000 * 60));
    }
}