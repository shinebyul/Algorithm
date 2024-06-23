#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

bool solution(string s) {
    int count = 0; 
    bool answer = true;

    for (char c : s) {
        if (c == '(') {
            count++; 
        } else { 
            count--; 
            if (count < 0) {
                answer = false;
                break;
            }
        }
    }
    
    if(count==0) answer = true;
    else answer=false;

    return answer;
}
