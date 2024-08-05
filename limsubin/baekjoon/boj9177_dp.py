# BOJ 9177: 단어 섞기
# https://www.acmicpc.net/problem/9177

import sys

def input():
    return sys.stdin.readline().strip()

N = int(input())

for n in range(1, N+1):
    a, b, c = input().split()

    size_a = len(a)
    size_b = len(b)
    size_c = len(c)

    result = [[False] * (size_b + 1) for _ in range(size_a + 1)]

    # 초기값
    result[0][0] = True
    for i in range(1, size_b + 1):
        if result[0][i-1]:
            result[0][i] = c[i-1] == b[i-1]
    for i in range(1, size_a + 1):
        if result[i-1][0]:
            result[i][0] = c[i-1] == a[i-1]

    # 메모이제이션
    for i in range(1, size_a + 1):
        for j in range(1, size_b + 1):
            if result[i-1][j]:
                result[i][j] = c[i+j-1] == a[i-1]
            if result[i][j-1]:
                result[i][j] = c[i+j-1] == b[j-1]

    if result[-1][-1]:
        answer = 'yes'
    else:
        answer = 'no'

    print(f'Data set {n}: {answer}')
