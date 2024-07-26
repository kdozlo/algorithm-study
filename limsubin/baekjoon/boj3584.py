# BOJ 3584: 가장 가까운 공통 조상
# https://www.acmicpc.net/problem/3584

import sys

def input():
    return sys.stdin.readline().strip()

def find(x, y):
    visited = [False] * (n + 1)

    # x에서 먼저 거슬러 올라가면서 방문 체크
    while True:
        visited[x] = True
        if x == parent[x]:
            break
        x = parent[x]

    # y에서 거슬러 올라가면서 체크된 곳이 있으면 반환
    while True:
        if visited[y]:
            return y
        y = parent[y]

t = int(input())
for _ in range(t):
    n = int(input())
    parent = [i for i in range(n+1)] # 부모 노드

    for _ in range(n-1):
        a, b = map(int, input().split())
        parent[b] = a

    x, y = map(int, input().split())
    print(find(x, y))