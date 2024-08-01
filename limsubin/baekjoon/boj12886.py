# BOJ 12886: 돌 그룹
# https://www.acmicpc.net/problem/12886

from collections import deque

def bfs(a, b, c):
    if a == b == c:
        return 1

    # 전체 개수는 변하지 않는다!
    total = a + b + c

    x = min(a, b, c)
    y = max(a, b, c)

    queue = deque()
    queue.append([x, y, total-x-y]) # a, b, c
    visited[x][y] = True

    while queue:
        a, b, c = queue.popleft()

        # 2개 고르기
        for x, y in (a, b), (b, c), (a, c):
            if x == y:
                continue

            # 큰 쪽은 빼주고, 작은 쪽은 더해주기
            if x > y:
                x -= y
                y += y
            else:
                y -= x
                x += x
            c = total - x - y

            if x == y == c:
                return 1

            # 어차피 전체 개수는 고정이기 때문에 최소, 최대를 넣어 중복을 제거
            xx = min(x, y, c)
            yy = max(x, y, c)

            if visited[xx][yy]:
                continue

            queue.append([xx, yy, c])
            visited[xx][yy] = True

    return 0

a, b, c = map(int, input().split())
visited = [[False] * (a + b + c) for _ in range(a + b + c)]
print(bfs(a, b, c))