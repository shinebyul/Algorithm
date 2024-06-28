#include <vector>
#include <algorithm>

using namespace std;

bool compare(int a, int b) {
    string strA = to_string(a);
    string strB = to_string(b);
    
    return strA + strB > strB + strA;
}

string solution(vector<int> numbers) {
    string answer = "";
    
    sort(numbers.begin(), numbers.end(), compare);
    
    if (numbers[0] == 0) {
        return "0";
    }
    
    for (int num : numbers) {
        answer += to_string(num);
    }
    
    return answer;
}