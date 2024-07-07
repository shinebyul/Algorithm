#include <stdio.h>
#include <stdlib.h>

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }

    swap(&arr[i + 1], &arr[high]);
    return i + 1;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

int main() {
    int N;
    scanf("%d", &N);

    int* p = (int*)malloc(N * sizeof(int));

    for (int i = 0; i < N; i++) {
        scanf("%d", &p[i]);
    }

    quickSort(p, 0, N - 1);

	int total=0;

    for(int i=0;i<N;i++){
		total+=p[i]*(N-i);
	}

	printf("%d",total);

    free(p); // 메모리 해제

    return 0;
}
