#include <stdio.h>
#include <stdlib.h>

int min(int a, int b) {
    return a < b ? a : b;
}

int main() {
    int k, n;
    scanf("%d", &k);
    scanf("%d", &n);
    getchar();

    // 원하는 결과값 입력받기
    char *result = (char *)malloc((k + 1) * sizeof(char));
    for (int i = 0; i < k; i++) {
        scanf("%c", &result[i]);
    }
    result[k] = '\0';
    getchar();

    // 사다리 입력받기
    int hide = -1;
    char **ladder = (char **)malloc(n * sizeof(char *));
    for (int i = 0; i < n; i++) {
        ladder[i] = (char *)malloc((k - 1) * sizeof(char));
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k - 1; j++) {
            scanf("%c", &ladder[i][j]);
            if (ladder[i][j] == '?') hide = i;
        }
        getchar();
    }

    int *up = (int *)malloc(k * sizeof(int));
    int *down = (int *)malloc(k * sizeof(int));

    for (int i = 0; i < k; i++) {
        up[i] = i;
    }

    // 위에서 아래로 내려오기
    for (int i = 0; i < hide; i++) {
        for (int j = 0; j < k - 1; j++) {
            if (ladder[i][j] == '-') {
                int temp = up[j];
                up[j] = up[j + 1];
                up[j + 1] = temp;
            }
        }
    }

    // 결과를 down 배열에 저장
    for (int i = 0; i < k; i++) {
        down[i] = result[i] - 'A';
    }

    // 아래에서 위로 올라오기
    for (int i = n - 1; i > hide; i--) {
        for (int j = 0; j < k - 1; j++) {
            if (ladder[i][j] == '-') {
                int temp = down[j];
                down[j] = down[j + 1];
                down[j + 1] = temp;
            }
        }
    }

    char *ret = (char *)malloc((k - 1) * sizeof(char));
    for (int i = 0; i < k - 1; i++) {
        ret[i] = '*';
    }

    for (int i = 0; i < k - 1; i++) {
        if (up[i] == down[i + 1] && up[i + 1] == down[i]) {
            ret[i] = '-';
            int temp = up[i];
            up[i] = up[i + 1];
            up[i + 1] = temp;
        }
    }

    for (int i = 0; i < k - 1; i++) {
        if (up[i] != down[i]) {
            for (int j = 0; j < k - 1; j++) {
                ret[j] = 'x';
            }
            break;
        }
    }

    for (int i = 0; i < k - 1; i++) {
        printf("%c", ret[i]);
    }
    printf("\n");

    free(result);
    for (int i = 0; i < n; i++) {
        free(ladder[i]);
    }
    free(ladder);
    free(up);
    free(down);
    free(ret);

    return 0;
}
