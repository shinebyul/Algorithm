import java.util.*;
class Solution {
    static int target = 2; // 후보 진법:  target ~ 9 
    static char [] blackList = {' ', '+', '-', '=', 'X'};
    static ArrayList<String> A = new ArrayList<>(); // 정상 수식 
    static ArrayList<String> Q = new ArrayList<>(); // 풀어야 하는 수식 
    static ArrayList<ArrayList<String>> A_List = new ArrayList();
    static ArrayList<ArrayList<String>> Q_List = new ArrayList();
    static boolean [] possible = new boolean [10]; // 가능한 진법 
    public String[] solution(String[] expressions) {
        
        function(expressions);
        Arrays.fill(possible, true);
        for(String tar : A){
            function2(tar, "A");
        }
        for(String tar : Q){
            function2(tar, "Q");
        }
        function3();
        return function4();
    }
    public static String [] function4(){
        
        for(ArrayList<String> list : Q_List){
            String first = list.get(0);
            String second = list.get(2);
            
            String result = "";
            boolean flag = false;
            
            for(int i = target; i <= 9; i++){
                if(!possible[i]) continue;
                int cnt = 0;
                int first_int = 0;
                int second_int = 0;
                for(int j = first.length() - 1; j >=0; j--){
                    first_int += (int) Math.pow(i, cnt) * (first.charAt(j) - '0');
                    cnt++;
                }
                cnt = 0;
                for(int j = second.length() - 1; j >=0; j--){
                    second_int += (int) Math.pow(i, cnt) * (second.charAt(j) - '0');
                    cnt++;
                }
                if(list.get(1).equals("+")){
                    int temp = first_int + second_int;
                    StringBuilder sb = new StringBuilder();
                    while(temp >= i){
                        sb.append(temp % i);
                        temp /= i;
                    }
                    sb.append(temp);
                    sb.reverse();
                    String temp2 = sb.toString();
                    if(result.equals("")){
                       result = temp2;
                    }
                    else{
                       if(!result.equals(temp2)){
                           flag = true;
                       } 
                    }
                }
                else{
                   int temp = first_int - second_int;
                    StringBuilder sb = new StringBuilder();
                    while(temp >= i){
                        sb.append(temp % i);
                        temp /= i;
                    }
                    sb.append(temp);
                    sb.reverse();
                    String temp2 = sb.toString();
                   if(result.equals("")){
                       result = temp2; 
                   }
                   else{
                      if(!result.equals(temp2)){
                           flag = true;
                       } 
                   }
                }
            }
            if(!flag){ // result 삽입 
                list.set(4, result);
            }
            else{
                list.set(4, "?");
            }
        }
        String [] answer = new String [Q_List.size()];
        for(int i = 0; i < Q_List.size(); i++){
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = Q_List.get(i);
            for(int j = 0; j < 5; j++){
                sb.append(list.get(j));
                if(j != 4){
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    public static void function3(){ // 정상 수식에서 불가능한 진법 찾기 
        for(ArrayList<String> list : A_List){
             String first  = list.get(0);
             String second = list.get(2);
             String result = list.get(4);
            for(int i = target; i <= 9; i++){
                if(!possible[i]) continue;
                int cnt = 0;
                int first_int = 0;
                int second_int = 0;
                int result_int = 0;
                for(int j = first.length() - 1; j >=0; j--){
                    first_int += (int) Math.pow(i, cnt) * (first.charAt(j) - '0');
                    cnt++;
                }
                cnt = 0;
                for(int j = second.length() - 1; j >=0; j--){
                    second_int += (int) Math.pow(i, cnt) * (second.charAt(j) - '0');
                    cnt++;
                }
                cnt = 0;
                for(int j = result.length() - 1; j >=0; j--){
                    result_int += (int) Math.pow(i, cnt) * (result.charAt(j) - '0');
                    cnt++;
                }
                if(list.get(1).equals("+")){
                    if(first_int + second_int != result_int){
                        possible[i] = false;
                    }
                }
                else{
                    if(first_int - second_int != result_int){
                        possible[i] = false;
                    }
                }
            }
        }
    }
    
    public static void function2(String tar, String check){ // 분리하기 
        String [] split = tar.split(" ");
        ArrayList<String> temp = new ArrayList<>();
        for(String cur : split){
            temp.add(cur);
        }
        if(check.equals("A")){
            A_List.add(temp);
        }
        else Q_List.add(temp);
    }
    public static void function(String [] expressions){ // 가장 높은 숫자 찾기 
        for(String tar : expressions){
            boolean q = false;
            for(int i = 0; i < tar.length(); i++){
                char cur = tar.charAt(i);
                boolean flag = false;
                for(char check : blackList){
                    if(check == cur){
                        flag = true;
                        if(check == 'X') q = true;
                        break;
                    }
                }
                if(flag) continue;
                int temp = cur - '0' + 1;
                if(target < temp) target = temp; 
            }
            if(q){
                Q.add(tar);
            }
            else{
                A.add(tar);
            }
        }
    }
}