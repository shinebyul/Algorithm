#include <stdio.h>
#include <stdlib.h>

int min(int a, int b);

int main(){

    int k, n;
    scanf("%d",&k);
    scanf("%d",&n);
    getchar();

    //원하는 결과값 입력받기
    char *result = (char*)malloc(k*sizeof(char));
    for(int i=0;i<k;i++){
        scanf("%c",&result[i]);
    }
    getchar();


    // 사다리 입력받기
    int hide;
    char **ladder = (char**)malloc(n*sizeof(char*));
    for(int i=0;i<n;i++){
        ladder[i]=(char*)malloc((k-1)*sizeof(char));
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<k-1;j++){
            scanf("%c",&ladder[i][j]);
            if(ladder[i][j]=='?') hide=i;
        }
        getchar();
    }


    int *up = (int*)malloc(k*sizeof(int));
    int *down = (int*)malloc(k*sizeof(int));

    for(int i=0;i<k;i++){
        up[i]=i;
    }

    // printf("hide : %d\n", hide);

    //위에꺼 아래로 내리기
    for(int i=0;i<k;i++){
        for(int j=0;j<hide;j++){
            if(up[i]!=0 && ladder[j][up[i]-1]=='-'){
                up[i]-=1;
            }else if(up[i]!=k-1 && ladder[j][up[i]]=='-'){
                up[i]+=1;
            }
        }
    }

    //result를 down으로 초기화
    for(int i=0;i<k;i++){
        down[result[i]-'A']=i;
    }


    //아래꺼 위로 올리기
    for(int i=0;i<k;i++){
        for(int j=n-1;j>hide;j--){
            if(down[i]!=0 && ladder[j][down[i]-1]=='-'){
                down[i]-=1;
            }else if(down[i]!=k-1 && ladder[j][down[i]]=='-'){
                down[i]+=1;
            }
        }
    }

    char *ret = (char*)malloc((k-1)*sizeof(char));
    for(int i=0;i<k-1;i++){
        ret[i]='*';
    }

int m;
    for(int i=0; i<k;i++){
        if(up[i]-down[i]==1 || up[i]-down[i]==-1){
            m= min(up[i],down[i]);
            if(ret[m-1]=='-' || ret[m+1]=='-'){
                for(int i=0;i<k-1;i++){
                    printf("x");
                }
                return 0;
            }
            ret[m]='-';
        }else if(up[i]!=down[i]){
            for(int i=0;i<k-1;i++){
                printf("x");
            }
            return 0;
        }
    }

    for(int i=0;i<k-1;i++){
        printf("%c",ret[i]);
    }

    return 0;
}


int min(int a, int b){
    if(a<=b) return a;
    return b;
}

