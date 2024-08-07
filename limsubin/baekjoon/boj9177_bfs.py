# BOJ 9177: 단어 섞기
# https://www.acmicpc.net/problem/9177

import sys
from collections import deque

def input():
    return sys.stdin.readline().strip()

def bfs(a, b, c):
    queue = deque()
    queue.append([0, 0])

    size_a = len(a)
    size_b = len(b)
    size_c = len(c)

    # 방문한 a, b 의 길이
    visited = [[False] * (size_b + 1) for _ in range(size_a + 1)]
    visited[0][0] = True

    while queue:
        x, y = queue.popleft()

        # c의 다음 문자가 a의 다음 문자와 일치할 때
        if x+1 <= size_a and not visited[x+1][y] and c[x + y] == a[x]:
            # c 탐색 완료
            if x + y + 1 == size_c:
                return "yes"
            # 방문 체크 및 큐에 삽입
            visited[x+1][y] = True
            queue.append([x+1, y])

        # c의 다음 문자가 b의 다음 문자와 일치할 때
        if y+1 <= size_b and not visited[x][y+1] and c[x + y] == b[y]:
            # c 탐색 완료
            if x + y + 1 == size_c:
                return "yes"
            # 방문 체크 및 큐에 삽입
            visited[x][y+1] = True
            queue.append([x, y+1])

    return "no"

N = int(input())

for n in range(1, N+1):
    a, b, c = input().split()
    print(f'Data set {n}: {bfs(a, b, c)}')
