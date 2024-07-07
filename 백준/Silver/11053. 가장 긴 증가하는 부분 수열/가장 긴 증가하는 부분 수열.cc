#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int max(int x, int y){
    if(x>y) return x;
    return y;
}

int findMax(int length[], int N){
    int m=0;
    for(int i=0;i<N;i++){
        m=max(m,length[i]);
    }
    return m;
}

int main(){
    int N, num[1000];

    scanf("%d",&N);

    for(int i=0;i<N;i++){
        scanf("%d",&num[i]);
    }

    int length[1000];
    
    for(int i=0;i<N;i++){
        length[i]=1;
    }

    for(int i=1;i<N;i++){
        for(int j=0;j<i;j++){
            if(num[i]>num[j]){
                length[i]=max(length[i], length[j]+1);
            }
        }
    }

    int m = findMax(length, N);
    printf("%d", m);

    return 0;
}