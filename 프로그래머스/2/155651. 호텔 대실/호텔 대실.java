import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) throws Exception{
        int answer = 0;
        
        book_time = sort(book_time);
        LocalDateTime[][] date = toDate(book_time);
        answer = hotel(date);
        
        return answer;
    }
    
    public int hotel(LocalDateTime[][] date){
        List<LocalDateTime> rooms = new ArrayList<>();
        rooms.add(date[0][1]);
        
        for(int i=1;i<date.length;i++){
            int j=0;
            for(j=0;j<rooms.size();j++){
                if((rooms.get(j).plusMinutes(10)).compareTo(date[i][0])<=0){
                    rooms.set(j,rooms.get(j).compareTo(date[i][1]) < 0 ? date[i][1] : rooms.get(j));
                    break;
                }
            }
            if(j==rooms.size()){
                rooms.add(date[i][1]);
            }
        }
        
        return rooms.size();
    }
    
    public String[][] sort(String[][] book_time){
        //시작시간을 기준으로 오름차순 정렬 
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        return book_time;
    }
    
    public LocalDateTime[][] toDate(String[][] book_time) throws Exception{
        // SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        LocalDateTime[][] date = new LocalDateTime[book_time.length][2];
        
        for(int i=0;i<book_time.length;i++){
            for(int j=0;j<2;j++){
                date[i][j] = LocalDateTime.now().with(LocalTime.parse(book_time[i][j], formatter));
            }
        }
        
        return date;
    }
}