# BOJ 4883: 삼각 그래프
# https://www.acmicpc.net/problem/4883

import sys

def input():
    return sys.stdin.readline().strip()

k = 1
while True:
    n = int(input())

    if n == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(n)]

    graph[0][2] += graph[0][1]
    graph[1][0] += graph[0][1]
    graph[1][1] += min(graph[0][1], graph[0][2], graph[1][0])
    graph[1][2] += min(graph[0][1], graph[0][2], graph[1][1])

    for i in range(2, n):
        graph[i][0] += min(graph[i-1][0], graph[i-1][1])
        graph[i][1] += min(graph[i-1][0], graph[i-1][1], graph[i-1][2], graph[i][0])
        graph[i][2] += min(graph[i-1][1], graph[i-1][2], graph[i][1])

    print(f'{k}. {graph[n-1][1]}')
    k += 1