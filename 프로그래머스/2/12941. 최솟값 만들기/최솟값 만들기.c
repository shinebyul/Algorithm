#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <limits.h>

int asc(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int desc(const void *a, const void *b) {
    return (*(int*)b - *(int*)a);
}

// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.
int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;

    qsort(A, A_len, sizeof(int), asc);
    qsort(B, B_len, sizeof(int), desc);
    

    for (int i = 0; i < A_len; i++) {
        answer += A[i] * B[i];
    }
    
    
    return answer;
}