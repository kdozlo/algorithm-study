# BOJ 18427: 함께 블록 쌓기
# https://www.acmicpc.net/problem/18427

import sys

def input():
    return sys.stdin.readline().strip()

n, m, h = map(int, input().split())

result = [[0] * (h+1) for _ in range(n+1)]
result[0][0] = 1 # 블록을 사용하지 않는 경우

for i in range(1, n+1):
    # 블록을 사용하지 않는 경우를 고려하기 위해 확장!
    blocks = [0] + list(map(int, input().split()))

    for block in blocks:
        # 해당 블록과 합쳐서 합이 j가 되는 경우의 수를 구한다.
        for j in range(block, h+1):
            result[i][j] += result[i-1][j-block]

print(result[-1][-1] % 10007)
