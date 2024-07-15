# BOJ 18429: 근손실
# https://www.acmicpc.net/problem/18429

import sys

def input():
    return sys.stdin.readline().strip()

def permutation(cnt, weight):
    global answer

    # 가지치기
    if weight < 500:
        return

    # 완성!
    if cnt == n:
        answer += 1
        return

    # 순열!
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            permutation(cnt+1, weight + kit[i])
            visited[i] = False

n , k = map(int, input().split())

kit = list(map(int, input().split()))
for i in range(n):
    kit[i] -= k # 중량 감소

answer = 0
visited = [False] * n
permutation(0, 500)
print(answer)