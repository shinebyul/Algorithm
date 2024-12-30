//문자열 S가 주어졌을 때, S의 서로 다른 부분 문자열의 개수를 구하는 프로그램을 작성하시오.
//부분 문자열은 S에서 연속된 일부분을 말하며, 길이가 1보다 크거나 같아야 한다.
//예를 들어, ababc의 부분 문자열은 a, b, a, b, c, ab, ba, ab, bc, aba, bab, abc, abab, babc, ababc가 있고, 서로 다른것의 개수는 12개이다.

//첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
//ababc
//길이 5

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        
        //a, b, a, b, c
        HashSet set = new HashSet<String>();
        Stack<String> stack = new Stack<>();
        stack.push(S);
        set.add(S);
        
        while(!stack.isEmpty()){
            String str = stack.pop();
            int len = str.length();
            
            if(len==1){
                set.add(str);
                continue;
            }
            
            String sub1 = str.substring(0, len-1);
            String sub2 = str.substring(1, len);
            
            if(set.add(sub1)){
                stack.push(sub1);
            }
            if(set.add(sub2)){
                stack.push(sub2);
            }
        }
        
        System.out.println(set.size());
    }
}