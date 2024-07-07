#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int max( int x, int y){
    if(x>y) return x;
    return y;
}

int N, M;
int vertax[1001][1001]={0};
int visit[1001]={0};

void rDFS(int v){
    visit[v]=1;
    for(int i=1;i<=N;i++){
        if(vertax[v][i]==1 && visit[i]==0){
            rDFS(i);
        }
    }
}

int DFS(){
    int ret=0;
    for(int i=1;i<=N;i++){
        if(!visit[i]){
            rDFS(i);
            ret++;
        }
    }
    return ret;
}

int main(){
    
    scanf("%d %d",&N,&M);
    for(int i=0;i<M;i++){
        int x, y;
        scanf("%d %d",&x,&y);
        vertax[x][y]=1;
        vertax[y][x]=1;
    }

    int ret = DFS();
    printf("%d",ret);

    return 0;
}