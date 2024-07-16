# BOJ 21610: 마법사 상어와 비바라기
# https://www.acmicpc.net/problem/21610

import sys

def input():
    return sys.stdin.readline().strip()

def move(d, s):
    for i in range(len(cloud)):
        x, y = cloud[i]
        mx = adjust_range(x + dx[d] * s)
        my = adjust_range(y + dy[d] * s)

        cloud[i] = [mx, my]
        visited[mx][my] = True

def adjust_range(x):
    while x < 0:
        x += n
    while x >= n:
        x -= n
    return x

def rain():
    for x, y in cloud:
        board[x][y] += 1

def copybug():
    for x, y in cloud:
        cnt = 0
        for i in range(1, 8, 2):
            mx = x + dx[i]
            my = y + dy[i]

            if mx < 0 or mx >= n or my < 0 or my >= n:
                continue

            if board[mx][my] > 0:
                cnt += 1
        board[x][y] += cnt

def make_cloud():
    temp = []
    for i in range(n):
        for j in range(n):
            # 구름이 사라진 칸 제외
            if visited[i][j]:
                continue
            if board[i][j] >= 2:
                board[i][j] -= 2
                temp.append([i, j])
    return temp

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

# 구름 정보
cloud = [[i, j] for i in range(n-2, n) for j in range(2)]
visited = [[False] * n for _ in range(n)]

# 이동 방향
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

for _ in range(m):
    d, s = map(int, input().split())

    # 모든 구름이 d 방향으로 s칸 이동
    move(d-1, s)

    # 비 -> 물의 양 증가
    rain()

    # 물복사버그 마법 -> 대각선 바구니 개수만큼 물의 양 증가
    copybug()

    # 구름이 사라진 칸을 제외하고 물의 양이 2 이상인 모든 칸에 구름이 생긴다.
    cloud = make_cloud()
    visited = [[False] * n for _ in range(n)]

# 바구니에 들어있는 물의 양의 합
answer = 0
for i in range(n):
    answer += sum(board[i])

print(answer)