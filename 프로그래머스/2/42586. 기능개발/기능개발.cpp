#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    stack<int> s;

    for (int i = progresses.size() - 1; i >= 0; i--) {
        s.push(i);
    }

    while (!s.empty()) {
        int count = 0;

        for (int i = 0; i < progresses.size(); i++) {
            progresses[i] += speeds[i];
        }

        while (!s.empty() && progresses[s.top()] >= 100) {
            s.pop();
            count++;
        }

        if (count > 0) {
            answer.push_back(count);
        }
    }

    return answer;
}