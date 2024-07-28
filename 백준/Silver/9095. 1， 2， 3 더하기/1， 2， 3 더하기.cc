#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int factorial(int n){
	if(n==0) return 1;
	int ret=1;
	for(int i=2;i<=n;i++){
		ret*=i;
	}
	return ret;
}

int combination(int n, int r){
	double total=1;
	for(int i=n;i>r;i--){
		total*=(double)i/(double)(i-r);
	}
	int ret=(int)total;
	return ret;
}

int main(){
	
	int T,N;
	scanf("%d", &T);
	
	for(int i=0;i<T;i++){
		scanf("%d",&N);
		
		int t1=N, t2;
		int ret=1;
		for(int j=0;j<N;j++){
			// printf("j: %d\n",j);
			t1=N-j;
			for(int k=1;k*2<=t1;k++){
				t2=t1-k*2;
				if(t2%3==0){
					// printf("1 : %d 2 : %d 3 : %d\n",j,k,t2/3);
					ret+=factorial(j+k+(t2/3))/(factorial(j)*factorial(k)*factorial(t2/3));
				}
			}
			for(int k=1;k*3<=t1;k++){
				t2=t1-k*3;
				if(t2==0){
					// printf("1 : %d 3 : %d\n",j,k);
					ret+=factorial(j+k)/(factorial(j)*factorial(k));
				}
				
			}
		}
		printf("%d\n",ret);
	}



	return 0;
}