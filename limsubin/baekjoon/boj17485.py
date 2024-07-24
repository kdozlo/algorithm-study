# BOJ 17485: 진우의 달 여행 (Large)
# https://www.acmicpc.net/problem/17485

import sys

def input():
    return sys.stdin.readline().strip()

n, m = map(int, input().split())
space = [list(map(int, input().split())) for _ in range(n)]

# 편리한 계산을 위해 양 옆으로 float('INF') 값 넣어줌!
result = [[[float('INF')] + [space[i][j] for j in range(m)] + [float('INF')] for i in range(n)] for _ in range(3)]
for i in range(1, n):
    for j in range(1, m+1):
        # 왼쪽으로 가는 대각선
        result[0][i][j] += min(result[1][i-1][j], result[2][i-1][j-1])
        # 아래쪽
        result[1][i][j] += min(result[0][i-1][j+1], result[2][i-1][j-1])
        # 오른쪽으로 가는 대각선
        result[2][i][j] += min(result[0][i-1][j+1], result[1][i-1][j])

answer = min(min(result[0][-1][1:m+1]), min(result[1][-1][1:m+1]), min(result[2][-1][1:m+1]))
print(answer)